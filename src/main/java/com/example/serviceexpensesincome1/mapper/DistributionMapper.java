package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.DistributionDTO;
import com.example.serviceexpensesincome1.entity.Distribution;
import com.example.serviceexpensesincome1.entity.DistributionHistory;
import jakarta.persistence.Column;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DistributionMapper {
    @Mapping(target = "accountYear", source = "accountYear",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "dateAccount", source = "dateAccount",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "id", ignore = true)
    Distribution toEntity(DistributionDTO distributionDTO);
    @Mapping(target = "dateRegistration", ignore = true)
   DistributionHistory toHistory(Distribution distribution);

    @Mapping(target = "accountYear", source = "accountYear",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "dateAccount", source = "dateAccount",
            dateFormat = "dd-MM-yyyy ")
    DistributionDTO toDTO(Distribution distribution);

    @Mapping(target = "accountYear", source = "accountYear",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "dateAccount", source = "dateAccount",
            dateFormat = "dd-MM-yyyy ")
    List<DistributionDTO> toDTOlist(List<Distribution> distributionListFinal);
}
