package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/** DTO прогнозирования */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ForecastingDTO {
    int idBuilding;
    int nomberScore;
    int department =1;
    List<Integer> sumMonth;

}
