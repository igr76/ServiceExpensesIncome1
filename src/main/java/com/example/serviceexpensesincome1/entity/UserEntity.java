package com.example.serviceexpensesincome1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

/**
 * Сущность пользователя
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
@Entity
public class UserEntity {

  /**
   * id пользователя
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  Integer id;

  /**
   * Имя пользователя
   */
  //@Column(name = "first_name")
  String firstName;

  /**
   * Фамилия пользователя
   */
 // @Column(name = "last_name")
  String lastName;

  /**
   * почта пользователя
   */
 // @Column(name = "email")
  String email;

  /**
   * пароль пользователя
   */
  //@Column(name = "password")
  String password;

  /**
   * телефон пользователя
   */
 // @Column(name = "phone")
  String phone;

  /**
   * дата регистрации пользователя
   */
 // @Column(name = "reg_date")
  LocalDateTime regDate;



//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//    UserEntity that = (UserEntity) o;
//    return id != null && Objects.equals(id, that.id);
//  }
//
//  @Override
//  public int hashCode() {
//    return getClass().hashCode();
//  }
}