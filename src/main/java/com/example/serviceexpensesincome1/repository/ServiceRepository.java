package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
