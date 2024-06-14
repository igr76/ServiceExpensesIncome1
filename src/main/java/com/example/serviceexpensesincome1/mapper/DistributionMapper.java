package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.DistributionDTO;
import com.example.serviceexpensesincome1.entity.Distribution;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DistributionMapper {
    Distribution toEntity(DistributionDTO distributionDTO);


    DistributionDTO toDTO(Distribution distribution);
}
