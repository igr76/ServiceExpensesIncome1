package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.dto.DistributionDTO;
import com.example.serviceexpensesincome1.entity.Distribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionRepository extends JpaRepository<Distribution, Integer> {
  //  Distribution findById(int id);
}
