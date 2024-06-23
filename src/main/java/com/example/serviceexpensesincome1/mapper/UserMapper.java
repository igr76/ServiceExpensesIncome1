package com.example.serviceexpensesincome1.mapper;


import com.example.serviceexpensesincome1.dto.UserDTO;
import com.example.serviceexpensesincome1.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * маппер для {@link com.example.serviceexpensesincome1.entity.UserEntity} готовый dto {@link com.example.serviceexpensesincome1.dto.UserDTO}
 */

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserEntity toEntity(UserDTO userDto);

  UserDTO toDTO(UserEntity userEntity);

}
