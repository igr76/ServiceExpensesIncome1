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
    @Query(nativeQuery = true, value = "SELECT * FROM distribution d JOIN union u ON u.id=d.id_contract JOIN building b " +
            "ON b.id=u.id_building JOIN  tools ON tools.id_building= b.id WHERE d.company=:company AND d/account_year=:" +
            "accountYear AND d.id_score=:idScore AND d.category_score= :categoryScore AND d.id_contract=:idContract " +
            "AND d.id_service=:idService ")
    List<Distribution> distributionCSV(String company,LocalDate accountYear,int idScore,int categoryScore
    ,int idContract,int idService);
}
