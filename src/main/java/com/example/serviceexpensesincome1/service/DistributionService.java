package com.example.serviceexpensesincome1.service;


import com.example.serviceexpensesincome1.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
/** Сервис распределения счетов */
public interface DistributionService {
    /** Получить распределения счет */
    DistributionDTO getDistributionId(int id);
    /** Обновить распределения счет */
    Object updateDistribution(Integer id, DistributionDTO distributionDTO);
    /** Удалить распределения счет по id */
    void removeDistribution(int id);
    /** Получить основных средств */
    ToolsDTO getToolsId(int id);
    /** Обновить основных средств */
    Object updateTools(Integer id, ToolsDTO toolsDTO);
    /** Удалить основных средств по id */
    void removeTools(int id);
    /** Получить услугу */
    ServiceDTO getServiceId(int id);
    /** Обновить услугу */
    Object updateService(Integer id, ServiceDTO serviceDTO);
    /** Удалить услугу по id */
    void removeService(int id);
    /** Получить договор */
    ContractDTO getContractFromId(int id);
    /** Обновить договор */
    Object updateContract(Integer id, ContractDTO contractDTO);
    /** Удалить договор по id */
    void removeContract(int id);
    /** Получить истории распределения расходов */
    List<DistributionHistoryDTO> getHistory(LocalDate year1, LocalDate year2);

   List<ForecastingDTO> getForecasting( LocalDate date1, LocalDate date2);

    List<DistributionDTO> CSVexport(MultipartFile file) throws IOException;
    /** Выгрузка распределения в формате  exel*/
    MultipartFile getXls();
    /** Получить здание */
    BuildingDTO getBuildingId(int id);
    /** Обновить здание */
    Object updateBuilding(Integer id, BuildingDTO buildingDTO);
    /** Удалить здание по id */
    void removeBuilding(int id);
}
