package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.ServiceDTO;
import com.example.serviceexpensesincome1.entity.Service;;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    Service toEntity(ServiceDTO serviceDTO);

    ServiceDTO toDTO(Service service);
}
