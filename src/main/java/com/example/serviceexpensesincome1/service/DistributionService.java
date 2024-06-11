package com.example.serviceexpensesincome.service;

import com.example.serviceexpensesincome.dto.ContractDTO;
import com.example.serviceexpensesincome.dto.DistributionDTO;
import com.example.serviceexpensesincome.dto.ServiceDTO;
import com.example.serviceexpensesincome.dto.ToolsDTO;

public interface DistributionService {
    DistributionDTO getDistributionId(int id);

    Object updateDistribution(Integer id, DistributionDTO distributionDTO);

    void removeDistribution(int id);

    ToolsDTO getToolsId(int id);

    Object updateTools(Integer id, ToolsDTO toolsDTO);

    void removeTools(int id);

    ServiceDTO getServiceId(int id);

    Object updateService(Integer id, ServiceDTO serviceDTO);

    void removeService(int id);

    ContractDTO getContractFromId(int id);

    Object updateContract(Integer id, ContractDTO contractDTO);

    void removeContract(int id);
}
