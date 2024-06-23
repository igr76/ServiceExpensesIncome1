package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
/** DTO здание */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BuildingDTO {
    /** ID здания */
    int Id;
    /** Начало владения */
    String beginningOwnership;
    /** Конец владения */
    String endOwnership;
    /** Конец действия измерения */
    int endMeasurement;

    /** Начало действия измерения */
    int beginningMeasurement;

    /** Единица измерения площади */
    Unit unitArea;
}
