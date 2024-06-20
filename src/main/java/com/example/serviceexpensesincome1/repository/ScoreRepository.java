package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.dto.ScoreDTO;
import com.example.serviceexpensesincome1.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    List<Score> findAll();
}
