package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.BuildingDTO;
import com.example.serviceexpensesincome1.dto.DistributionDTO;
import com.example.serviceexpensesincome1.entity.Building;
import com.example.serviceexpensesincome1.entity.Distribution;
import com.example.serviceexpensesincome1.entity.DistributionHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BuildingMapper {
    @Mapping(target = "beginningOwnership", source = "beginningOwnership",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "endOwnership", source = "endOwnership",
            dateFormat = "dd-MM-yyyy ")
    Building toEntity(BuildingDTO buildingDTO);
    @Mapping(target = "beginningOwnership", source = "beginningOwnership",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "endOwnership", source = "endOwnership",
            dateFormat = "dd-MM-yyyy ")
    BuildingDTO toDTO(Building building);
}
