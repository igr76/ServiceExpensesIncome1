package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.ToolsDTO;
import com.example.serviceexpensesincome1.entity.Tools;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ToolsMapper {
    @Mapping(target = "beginningOfOwnershipUnion", source = "beginningOfOwnershipUnion",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "endOfOwnershipUnion", source = "endOfOwnershipUnion",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "beginningOfOperation", source = "beginningOfOperation",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "endOfOperation", source = "endOfOperation",
            dateFormat = "dd-MM-yyyy ")
    Tools toEntity(ToolsDTO toolsDTO);

    @Mapping(target = "beginningOfOwnershipUnion", source = "beginningOfOwnershipUnion",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "endOfOwnershipUnion", source = "endOfOwnershipUnion",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "beginningOfOperation", source = "beginningOfOperation",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "endOfOperation", source = "endOfOperation",
            dateFormat = "dd-MM-yyyy ")
    ToolsDTO toDTO(Tools tools);
}
