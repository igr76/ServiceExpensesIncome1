package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.ToolsDTO;
import com.example.serviceexpensesincome1.entity.Tools;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ToolsMapper {
    @Mapping(target = "beginningOfOwnershipUnion", source = "beginningOfOwnershipUnion",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "endOfOwnershipUnion", source = "endOfOwnershipUnion",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "beginningOfOperation", source = "beginningOfOperation",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "endOfOperation", source = "endOfOperation",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    Tools toEntity(ToolsDTO toolsDTO);

    @Mapping(target = "beginningOfOwnershipUnion", source = "beginningOfOwnershipUnion",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "endOfOwnershipUnion", source = "endOfOwnershipUnion",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "beginningOfOperation", source = "beginningOfOperation",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "endOfOperation", source = "endOfOperation",
            dateFormat = "dd-MM-yyyy HH:mm:ss")
    ToolsDTO toDTO(Tools tools);
}
