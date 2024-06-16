package com.example.serviceexpensesincome1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
/** Cущность прогнозирования счетов */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Forecasting {
    /** ID  */
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    /** Позиция счета */
    int idBuilding;
    /** Счёт главной книги */
    int nomberScore;
    /** сумма за год */
    int sumYear;

}
