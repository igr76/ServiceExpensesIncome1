package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.entity.DistributionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface DistributionHistoryRepository extends JpaRepository<DistributionHistory, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM history WHERE date_registration BETWEEN :year1 AND :year2")
    List<DistributionHistory> findBetweenDate(LocalDate year1, LocalDate year2);
}
