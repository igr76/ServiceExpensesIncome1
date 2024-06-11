package com.example.serviceexpensesincome.dto;

import java.util.Date;

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
