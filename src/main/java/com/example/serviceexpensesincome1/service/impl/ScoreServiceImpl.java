package com.example.serviceexpensesincome1.service.impl;

import com.example.serviceexpensesincome1.dto.ScoreDTO;
import com.example.serviceexpensesincome1.entity.Score;
import com.example.serviceexpensesincome1.mapper.ScoreMapper;
import com.example.serviceexpensesincome1.repository.ScoreRepository;
import com.example.serviceexpensesincome1.service.ScoreService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScoreServiceImpl implements ScoreService {
     ScoreRepository scoreRepository;
     ScoreMapper scoreMapper;

    public ScoreServiceImpl(ScoreRepository scoreRepository, ScoreMapper scoreMapper) {
        this.scoreRepository = scoreRepository;
        this.scoreMapper = scoreMapper;
    }

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
