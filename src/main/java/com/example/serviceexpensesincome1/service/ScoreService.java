package com.example.serviceexpensesincome1.service;

import com.example.serviceexpensesincome1.dto.ScoreDTO;

import java.util.List;

public interface ScoreService {
    List<ScoreDTO> getScoreAll();

    void removeScore(int id);

    Object updateScore(Integer id, ScoreDTO scoreDTO);
}
