package com.example.serviceexpensesincome1.repository;

import com.example.serviceexpensesincome1.dto.ScoreDTO;
import com.example.serviceexpensesincome1.entity.Score;

import java.util.List;

public interface ScoreRepository {
    List<ScoreDTO> findAll();

    void delete(int id);

    Score findId(Integer id);

    void save(Score entity);
}
