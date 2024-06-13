package com.example.serviceexpensesincome1.service.impl;

import com.example.serviceexpensesincome1.dto.ScoreDTO;
import com.example.serviceexpensesincome1.entity.Score;
import com.example.serviceexpensesincome1.mapper.ScoreMapper;
import com.example.serviceexpensesincome1.repository.ScoreRepository;
import com.example.serviceexpensesincome1.service.ScoreService;

import java.util.List;

public class ScoreServiceImpl implements ScoreService {
    private ScoreRepository scoreRepository;
    private ScoreMapper scoreMapper;
    @Override
    public List<ScoreDTO> getScoreAll() {
        return scoreRepository.findAll();
    }

    @Override
    public void removeScore(int id) {
        scoreRepository.delete(id);

    }

    @Override
    public Object updateScore(Integer id, ScoreDTO scoreDTO) {
        Score score = scoreRepository.findId(id);
        scoreRepository.save(scoreMapper.toEntity(scoreDTO));
        return scoreDTO;
    }
}
