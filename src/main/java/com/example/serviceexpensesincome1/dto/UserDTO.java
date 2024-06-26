package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * DTO сущности
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {

  /** почта пользователя*/
  String email;

  /** Имя пользователя*/
  String firstName;
  /** id пользователя*/
  Integer id;
  /** Фамилия пользователя*/
  String lastName;
  /** телефон пользователя*/
  String phone;


}
