package com.example.serviceexpensesincome1.entity;

import com.example.serviceexpensesincome1.dto.Unit;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
/** Cущность здание */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Building {
    /** ID здания */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
