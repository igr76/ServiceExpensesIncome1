package com.example.serviceexpensesincome.service;

import com.example.serviceexpensesincome.dto.ScoreDTO;

public interface ScoreService {
    ScoreDTO getScoreAll();

    void removeScore(int id);

    Object updateScore(Integer id, ScoreDTO scoreDTO);
}
