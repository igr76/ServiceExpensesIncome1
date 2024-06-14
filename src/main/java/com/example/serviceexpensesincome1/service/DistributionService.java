package com.example.serviceexpensesincome1.service;


import com.example.serviceexpensesincome1.dto.*;

import java.util.Date;
import java.util.List;
/** Сервис распределения счетов */
public interface DistributionService {
    /** Получить здание */
    DistributionDTO getDistributionId(int id);
    /** Обновить здание */
    Object updateDistribution(Integer id, DistributionDTO distributionDTO);
    /** Удалить здание по id */
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
    List<DistributionHistoryDTO> getHistory(Date year1, Date year2);
}
