package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.ToolsDTO;
import com.example.serviceexpensesincome1.entity.Tools;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToolsMapper {
    Tools toEntity(ToolsDTO toolsDTO);

    ToolsDTO toDTO(Tools tools);
}
