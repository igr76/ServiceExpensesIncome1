package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.ScoreDTO;
import com.example.serviceexpensesincome1.entity.Score;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScoreMapper {
    Score toEntity(ScoreDTO scoreDTO);
    ScoreDTO toDTO(Score score);
}
