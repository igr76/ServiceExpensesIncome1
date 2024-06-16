package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.DistributionDTO;
import com.example.serviceexpensesincome1.entity.Distribution;
import com.example.serviceexpensesincome1.entity.DistributionHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DistributionMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "accountYear", source = "accountYear",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "dateAccount", source = "dateAccount",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    Distribution toEntity(DistributionDTO distributionDTO);
    @Mapping(target = "DateRegistration", ignore = true)
    @Mapping(target = "accountYear", source = "accountYear",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "dateAccount", source = "dateAccount",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
   DistributionHistory toHistory(Distribution distribution);
    DistributionDTO toDTO(Distribution distribution);
}
