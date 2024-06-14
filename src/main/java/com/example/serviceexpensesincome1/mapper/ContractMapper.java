package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.ContractDTO;
import com.example.serviceexpensesincome1.dto.UserDTO;
import com.example.serviceexpensesincome1.entity.Contract;
import com.example.serviceexpensesincome1.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    Contract toEntity(ContractDTO contractDTO);


    ContractDTO toDTO(Contract contract);
}
