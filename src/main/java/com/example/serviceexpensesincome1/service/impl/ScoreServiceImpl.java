package com.example.serviceexpensesincome1.service.impl;

import com.example.serviceexpensesincome.dto.ScoreDTO;
import com.example.serviceexpensesincome1.repository.ScoreRepository;
import com.example.serviceexpensesincome1.service.ScoreService;

import java.util.List;

public class ScoreServiceImpl implements ScoreService {
    private ScoreRepository scoreRepository;
    @Override
    public List<ScoreDTO> getScoreAll() {
        return scoreRepository.findAll();
    }

    @Override
    public void removeScore(int id) {


    }

    @Override
    public Object updateScore(Integer id, ScoreDTO scoreDTO) {
        return null;
    }
}
