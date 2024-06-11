package com.example.serviceexpensesincome.entity;

import com.example.serviceexpensesincome.dto.Unit;

import java.util.Date;
/** Cущность здание */
public class Building {
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
