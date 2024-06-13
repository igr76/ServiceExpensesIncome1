package com.example.serviceexpensesincome1.service.impl;


import com.example.serviceexpensesincome1.dto.NewPassword;
import com.example.serviceexpensesincome1.dto.UserDTO;
import com.example.serviceexpensesincome1.entity.UserEntity;
import com.example.serviceexpensesincome1.exeption.ElemNotFound;
import com.example.serviceexpensesincome1.mapper.UserMapper;
import com.example.serviceexpensesincome1.repository.UserRepository;
import com.example.serviceexpensesincome1.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Сервис пользователей
 */
@NoArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

  private  UserRepository userRepository;
  private  UserMapper userMapper;


  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  /**
   * Получить данные пользователя
   */
  @Override
  public UserDTO getUser(String email) {
    log.info("Получить данные пользователя");
    UserEntity userEntity = findEntityByEmail(email);
    return userMapper.toDTO(userEntity);
  }

  /**
   * Обновить данные пользователя
   */
  @Override
  public UserDTO updateUser(UserDTO newUserDto) {
    log.info("FormLogInfo.getInfo()");

    String nameEmail = "";//authentication.getName();
    UserEntity userEntity = findEntityByEmail(nameEmail);
    int id = userEntity.getId();

    UserEntity oldUser = userRepository.findById(id);

    oldUser.setEmail(userEntity.getEmail());
    oldUser.setFirstName(newUserDto.getFirstName());
    oldUser.setLastName(newUserDto.getLastName());
    oldUser.setPhone(newUserDto.getPhone());

    try {
      oldUser.setRegDate(userEntity.getRegDate());
    } catch (Exception e) {
      log.info("Ошибка изменения даты регистрации");
    }

    userRepository.save(oldUser);

    return userMapper.toDTO(oldUser);
  }

  /**
   * Установить пароль пользователя
   */
  @Override
  public NewPassword setPassword(NewPassword newPassword) {
    log.info("FormLogInfo.getInfo()");
    return null;
  }

  /**
   * найти пользователя по email - логину
   *
   * @param email email - логину пользователя
   * @return пользователь
   */
  private UserEntity findEntityByEmail(String email) {
    log.info("FormLogInfo.getInfo()");
    return userRepository.findByEmail(email);//.get();
  }


}
