package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.entity.DistributionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DistributionHistoryRepository extends JpaRepository<DistributionHistory, Integer> {
    List<DistributionHistory> findBetweenDate(Date year1, Date year2);
}
