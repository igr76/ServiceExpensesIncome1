package com.example.serviceexpensesincome1.service;

import com.example.serviceexpensesincome1.dto.NewPassword;
import com.example.serviceexpensesincome1.dto.UserDTO;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.multipart.MultipartFile;


/**
 * сервис пользователя
 */
public interface UserService {

  /**
   * получить пользователя
   */
  UserDTO getUser(Authentication authentication);

  /**
   * обновить пользователя
   */
  UserDTO updateUser(UserDTO userDto, Authentication authentication) ;

  /**
   * установить новый пароль пользователя
   */
  NewPassword setPassword(NewPassword newPassword);


}
