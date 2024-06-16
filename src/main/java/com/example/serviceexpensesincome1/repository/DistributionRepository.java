package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.dto.DistributionDTO;
import com.example.serviceexpensesincome1.entity.Distribution;
import com.example.serviceexpensesincome1.entity.Forecasting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DistributionRepository extends JpaRepository<Distribution, Integer> {
    @Query(nativeQuery = true, value = "SELECT id_building,score,SUM(size_distribution)" +
            " FROM distribution WHERE account_year >=:date1 AND account_year <=:date2" +
            "GROUP BY id_building,score ")
    List<Forecasting> findForecasting(LocalDate date1, LocalDate date2);
    //  Distribution findById(int id);
}
