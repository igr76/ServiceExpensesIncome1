package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.entity.UserEntity;
import org.springframework.beans.MutablePropertyValues;

import java.util.Optional;

public interface UserRepository {
    UserEntity findByEmail(String email);

    UserEntity findById(int id);

    void save(UserEntity oldUser);

}
