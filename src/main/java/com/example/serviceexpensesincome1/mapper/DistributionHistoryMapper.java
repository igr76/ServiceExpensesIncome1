package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.DistributionHistoryDTO;
import com.example.serviceexpensesincome1.entity.DistributionHistory;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface DistributionHistoryMapper {
    DistributionHistoryDTO  toDTO(DistributionHistory distributionHistory);
    Collection<DistributionHistoryDTO> toDTOList(Collection<DistributionHistory> distributionHistoryCollection);
}
