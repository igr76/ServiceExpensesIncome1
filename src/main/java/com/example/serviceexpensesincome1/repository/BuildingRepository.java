package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
