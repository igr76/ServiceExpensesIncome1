package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
    Date beginningOfOwnership;
    /** Конец владения */
    Date endOfOwnership;
    /** Конец действия измерения */
    int endOfMeasurement;

    /** Начало действия измерения */
    int beginningOfMeasurement;

    /** Единица измерения площади */
    Unit UnitOfArea;
}
