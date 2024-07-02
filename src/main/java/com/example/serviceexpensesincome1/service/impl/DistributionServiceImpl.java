package com.example.serviceexpensesincome1.service.impl;

import com.example.serviceexpensesincome1.dto.*;
import com.example.serviceexpensesincome1.entity.*;
import com.example.serviceexpensesincome1.exeption.ElemNotFound;
import com.example.serviceexpensesincome1.mapper.*;
import com.example.serviceexpensesincome1.repository.*;
import com.example.serviceexpensesincome1.service.DistributionService;
import com.opencsv.CSVReader;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DistributionServiceImpl implements DistributionService {
     private DistributionRepository distributionRepository;
     private DistributionMapper distributionMapper;
     private ToolsRepository toolsRepository;
     private ToolsMapper toolsMapper;
     private ServiceRepository serviceRepository;
     private ServiceMapper serviceMapper;
     private ContractRepository contractRepository;
     private ContractMapper contractMapper;
     private DistributionHistoryRepository distributionHistoryRepository;
     private DistributionHistoryMapper distributionHistoryMapper;
     private  BuildingRepository buildingRepository;
     private  BuildingMapper buildingMapper;


    public DistributionServiceImpl(DistributionRepository distributionRepository, DistributionMapper distributionMapper,
                                   ToolsRepository toolsRepository, ToolsMapper toolsMapper, ServiceRepository serviceRepository,
                                   ServiceMapper serviceMapper, ContractRepository contractRepository, ContractMapper
                                           contractMapper, DistributionHistoryRepository distributionHistoryRepository,
                                   DistributionHistoryMapper distributionHistoryMapper, BuildingRepository buildingRepository, BuildingMapper buildingMapper) {
        this.distributionRepository = distributionRepository;
        this.distributionMapper = distributionMapper;
        this.toolsRepository = toolsRepository;
        this.toolsMapper = toolsMapper;
        this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
        this.contractRepository = contractRepository;
        this.contractMapper = contractMapper;
        this.distributionHistoryRepository = distributionHistoryRepository;
        this.distributionHistoryMapper = distributionHistoryMapper;
        this.buildingRepository = buildingRepository;
        this.buildingMapper = buildingMapper;
    }
    //------------------Ведение справочника распределения счетов;-------------------------------
    @Override
    public DistributionDTO getDistributionId(int id) {
        Distribution distribution = distributionRepository.findById(id).orElseThrow(ElemNotFound::new);
        return distributionMapper.toDTO(distribution);
    }

    @Override
    public Object updateDistribution(Integer id, DistributionDTO distributionDTO) {
        Distribution distribution = distributionRepository.findById(id).orElseThrow(ElemNotFound::new);
        distributionRepository.save(distributionMapper.toEntity(distributionDTO));
        DistributionHistory distributionHistory=distributionMapper.toHistory(distributionMapper.toEntity(distributionDTO));
        distributionHistory.setDateRegistration(LocalDate.now());
        distributionHistoryRepository.save(distributionHistory);
        return distributionDTO;
    }

    @Override
    public void removeDistribution(int id) {
        Distribution distribution = distributionRepository.findById(id).orElseThrow(ElemNotFound::new);
        distributionRepository.delete(distribution);
    }
    //------------------------------------------------Ведение справочника основных средств;------------------------------
    @Override
    public ToolsDTO getToolsId(int id) {
        Tools tools = toolsRepository.findById(id).orElseThrow(ElemNotFound::new);
        return toolsMapper.toDTO(tools);
    }

    @Override
    public Object updateTools(Integer id, ToolsDTO toolsDTO) {
        Tools tools = toolsRepository.findById(id).orElseThrow(ElemNotFound::new);
        toolsRepository.save(toolsMapper.toEntity(toolsDTO));
        return toolsDTO;
    }

    @Override
    public void removeTools(int id) {
        Tools tools = toolsRepository.findById(id).orElseThrow(ElemNotFound::new);
        toolsRepository.delete(tools);
    }
    //------------------------Ведение справочника работ/услуг;---------------------
    @Override
    public ServiceDTO getServiceId(int id) {
       com.example.serviceexpensesincome1.entity.Service service = serviceRepository.findById(id).orElseThrow(ElemNotFound::new);
        return serviceMapper.toDTO(service);
    }

    @Override
    public Object updateService(Integer id, ServiceDTO serviceDTO) {
        com.example.serviceexpensesincome1.entity.Service service = serviceRepository.findById(id).orElseThrow(ElemNotFound::new);
        serviceRepository.save(serviceMapper.toEntity(serviceDTO));
        return serviceDTO;
    }

    @Override
    public void removeService(int id) {
        com.example.serviceexpensesincome1.entity.Service service = serviceRepository.findById(id).orElseThrow(ElemNotFound::new);
        serviceRepository.delete(service);
    }
    //-------------------------Ведение справочника договоров----------------------
    @Override
    public ContractDTO getContractFromId(int id) {
        Contract contract = contractRepository.findById(id).orElseThrow(ElemNotFound::new);
        return contractMapper.toDTO(contract);
    }

    @Override
    public Object updateContract(Integer id, ContractDTO contractDTO) {
        Contract contract = contractRepository.findById(id).orElseThrow(ElemNotFound::new);
        contractRepository.save(contractMapper.toEntity(contractDTO));
        return contractDTO;
    }

    @Override
    public void removeContract(int id) {
        Contract contract = contractRepository.findById(id).orElseThrow(ElemNotFound::new);
        contractRepository.delete(contract);
    }
    //------------------------- истории результатов распределения расходов за период.------
    @Override
    public List<DistributionHistoryDTO> getHistory(LocalDate year1, LocalDate year2) {
        return (List<DistributionHistoryDTO>) distributionHistoryMapper.toDTOList(distributionHistoryRepository.findBetweenDate(year1,year2));
    }
    //-------------------------Получить прогноз за период--------------------
    @Override
    public List<ForecastingDTO> getForecasting( LocalDate date1, LocalDate date2) {
        Period period = Period.between(date1, date2);
        int countMonth=period.getMonths();
        List<ForecastingDTO> forecastingDTOList = null;
        List<Forecasting> forecastingList=distributionRepository.findForecasting(date1,date2);

        forecastingList.stream()
                .forEach(e-> {e.setSumYear(e.getSumYear()/countMonth);});

        for (Forecasting e: forecastingList) {
            ForecastingDTO forecastingDTO= new ForecastingDTO();
            forecastingDTO.setIdBuilding(e.getIdBuilding());
            forecastingDTO.setNomberScore(e.getNomberScore());
            List<Integer> list= new ArrayList<>();
            for (int i = 0; i < countMonth; i++) {
                list.add(e.getSumYear());
            }
            forecastingDTO.setSumMonth(list);
        }
        return forecastingDTOList;
    }
    //-------------------------Распределение счетов на основе CSV файла--------------------
    @Override
    public List<DistributionDTO> CSVexport(MultipartFile file) throws IOException {
        CSVReader csvReader = new CSVReader((Reader) file);
        String[] nextRecord;
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<CSVimport > csVimportList= new ArrayList<>();
        List<Distribution> distributionListFinal = new ArrayList<>();
        List<CSVexport > csVexportList= new ArrayList<>();
        List<Distribution> distributionList = new ArrayList<>();
        int sumSquaier =0;
        while ((nextRecord = csvReader.readNext()) != null) {
            CSVimport csVimport= new CSVimport();
            // получение данных из файла
            csVimport.setCompany(nextRecord[0]);
            csVimport.setCategoryScore(Integer.parseInt(nextRecord[1]));
            csVimport.setAccountYear(nextRecord[2]);
            csVimport.setIdScore(Integer.parseInt(nextRecord[3]));
            csVimport.setCategoryScore(Integer.parseInt(nextRecord[4]));
            csVimport.setIdContract(Integer.parseInt(nextRecord[5]));
            csVimport.setIdService(Integer.parseInt(nextRecord[6]));
            csVimport.setDateAccount(nextRecord[7]);
            csVimport.setMoneyNoNDS(Integer.parseInt(nextRecord[8]));
            distributionList = distributionRepository.distributionCSV(csVimport.getCompany(),
                    LocalDate.parse(csVimport.getAccountYear(),formatter),csVimport.getIdScore(),
                    csVimport.getCategoryScore(),csVimport.getIdContract(),csVimport.getIdService());
            // распределение средств
            // вычисление общей площади
            for (Distribution e: distributionList) {
                sumSquaier+=e.getSquare();
            }  //распределение средств учитывая площадь
            for (Distribution e: distributionList) {
                e.setScore(csVimport.getMoneyNoNDS()/(e.getSquare()*100/sumSquaier));
                distributionListFinal.add(e);
            }
            sumSquaier = 0;
        }
        return distributionMapper.toDTOlist(distributionListFinal);
    }
    //--------------------Выгрузка распределения в файл  exel--------------------------
    @Override
    public MultipartFile getXls() {
        Workbook workbook = new XSSFWorkbook();
        int i=1;
        try  {
            Sheet sheet = workbook.createSheet("Распределение счетов");
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("Компания");
            row.createCell(1).setCellValue("счета");
            row.createCell(2).setCellValue("Позиция счета");
            row.createCell(3).setCellValue("Номер позиции распределения");
            row.createCell(4).setCellValue("Дата отражения счета");
            row.createCell(5).setCellValue("id договора");
            row.createCell(6).setCellValue("id услуги");
            row.createCell(7).setCellValue("Класс услуги");
            row.createCell(8).setCellValue("Здание");
            row.createCell(9).setCellValue("Площадь");
            row.createCell(10).setCellValue("ID основного средства");
            row.createCell(11).setCellValue("Класс основного средства");
            row.createCell(12).setCellValue("Признак Использования");
            row.createCell(13).setCellValue("Распределенная сумма");
            row.createCell(14).setCellValue("Счёт главной книги");
            List<Distribution> distributionList= distributionRepository.findAll();
            for (Distribution e: distributionList) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(e.getCompany());
                row.createCell(1).setCellValue(e.getIdScore());
                row.createCell(2).setCellValue(e.getCategoryScore());
                row.createCell(3).setCellValue(String.valueOf(e.getAccountYear()));
                row.createCell(4).setCellValue(e.getNumberPosition());
                row.createCell(5).setCellValue(String.valueOf(e.getDateAccount()));
                row.createCell(6).setCellValue(e.getIdContract());
                row.createCell(7).setCellValue(e.getIdService());
                row.createCell(8).setCellValue(e.getClassService());
                row.createCell(9).setCellValue(e.getBuilding());
                row.createCell(10).setCellValue(e.getSquare());
                row.createCell(11).setCellValue(e.getIdO());
                row.createCell(12).setCellValue(e.getType().ordinal());
                row.createCell(13).setCellValue(e.isSignExpenses());
                row.createCell(14).setCellValue(e.getScore());
                i++;
            }
            // активировать при загрузке в файл
//            try (FileOutputStream out = new FileOutputStream("Example.xlsx")) {
//                workbook.write(out);
//            }  // Работа с файлом завершена, он закрыт
//            catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return (MultipartFile) workbook;
    }

    @Override
    public BuildingDTO getBuildingId(int id) {
        Building building= buildingRepository.findById(id).orElseThrow(ElemNotFound::new);
        return buildingMapper.toDTO(building);
    }

    @Override
    public Object updateBuilding(Integer id, BuildingDTO buildingDTO) {
        Building building= buildingRepository.findById(id).orElseThrow(ElemNotFound::new);
        buildingRepository.save(buildingMapper.toEntity(buildingDTO));
        return buildingDTO;
    }

    @Override
    public void removeBuilding(int id) {
        Building building= buildingRepository.findById(id).orElseThrow(ElemNotFound::new);
        buildingRepository.delete(building);

    }
    private DistributionDTO getDistributionDTO() {
        return new DistributionDTO("mts",1,1,"2021-10-10",1,
                "2021-10-10",1,1,"111","rty",2,1, Type.TYPE,true,1,1);
    }


}
