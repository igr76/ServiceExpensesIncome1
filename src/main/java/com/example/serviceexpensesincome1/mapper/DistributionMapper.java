package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.DistributionDTO;
import com.example.serviceexpensesincome1.entity.Distribution;
import com.example.serviceexpensesincome1.entity.DistributionHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DistributionMapper {
    @Mapping(target = "id", ignore = true)
    Distribution toEntity(DistributionDTO distributionDTO);
    @Mapping(target = "DateRegistration", ignore = true)
   DistributionHistory toHistory(Distribution distribution);
    DistributionDTO toDTO(Distribution distribution);
}
