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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public DistributionServiceImpl(DistributionRepository distributionRepository, DistributionMapper distributionMapper,
                                   ToolsRepository toolsRepository, ToolsMapper toolsMapper, ServiceRepository serviceRepository,
                                   ServiceMapper serviceMapper, ContractRepository contractRepository, ContractMapper
                                           contractMapper, DistributionHistoryRepository distributionHistoryRepository,
                                   DistributionHistoryMapper distributionHistoryMapper) {
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
    }
    //------------------Ведение справочника зданий;-------------------------------
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
        return null;//toolsMapper.toDTO(tools);
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
        List<DistributionHistory>  distributionHistoryList=distributionHistoryRepository.findBetweenDate(year1,year2);
        return null;
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
    //-------------------------Распределение счетов --------------------
    @Override
    public List<CSVexport> CSVexport(MultipartFile file) throws IOException {
        CSVReader csvReader = new CSVReader((Reader) file);
        String[] nextRecord;
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<CSVimport > csVimportList= new ArrayList<>();
        List<CSVexport > csVexportList= new ArrayList<>();
        while ((nextRecord = csvReader.readNext()) != null) {
            CSVimport csVimport= new CSVimport();
            csVimport.setCompany(nextRecord[0]);
            csVimport.setIdBuilding(Integer.parseInt(nextRecord[1]));
            csVimport.setAccountYear(nextRecord[2]);
            csVimport.setIdScore(Integer.parseInt(nextRecord[3]));
            csVimport.setCategoryScore(Integer.parseInt(nextRecord[4]));
            csVimport.setIdContract(Integer.parseInt(nextRecord[5]));
            csVimport.setIdService(Integer.parseInt(nextRecord[6]));
            csVimport.setDateAccount(nextRecord[7]);
            csVimport.setMoneyNoNDS(Integer.parseInt(nextRecord[8]));
            csVimportList.add(csVimport);
        }
        return List.of();
    }


}
