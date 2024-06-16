package com.example.serviceexpensesincome1.mapper;

import com.example.serviceexpensesincome1.dto.ScoreDTO;
import com.example.serviceexpensesincome1.entity.Score;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScoreMapper {
    @Mapping(target = "accountYear", source = "accountYear",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "dateAccount", source = "dateAccount",
            dateFormat = "dd-MM-yyyy ")
    Score toEntity(ScoreDTO scoreDTO);
    @Mapping(target = "accountYear", source = "accountYear",
            dateFormat = "dd-MM-yyyy ")
    @Mapping(target = "dateAccount", source = "dateAccount",
            dateFormat = "dd-MM-yyyy ")
    ScoreDTO toDTO(Score score);
}
