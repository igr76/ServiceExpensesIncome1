package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.entity.UserEntity;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    @Query(nativeQuery = true, value = "SELECT * DISTINCT FROM users WHERE email= :email ")
    UserEntity findByEmail(String email);
}
