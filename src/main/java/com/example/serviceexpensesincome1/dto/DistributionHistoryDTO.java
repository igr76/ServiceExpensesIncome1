package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

/**  история  распределения счетов */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DistributionHistoryDTO {
    /** Компания */
    String company;
    /** Номер счета */
    int idScore;
    /** Позиция счета */
    int idBuilding;
    /** Год счета */
    LocalDate accountYear;
    /** Номер позиции распределения */
    int numberPosition;
    /** Дата отражения счета в учётной системе */
    LocalDate dateAccount;
    /** id договора */
    int idContract;
    /** id услуги */
    int idService;
    /** Класс услуги*/
    String classService;
    /** Здание */
    String building;
    /** Площадь */
    int square;
    /** ID основного средства */
    int Id;
    /** Класс основного средства */
    Type type;
    /** Признак Использования */
    boolean signExpenses;
    /** Распределенная сумма */
    int sizeDistribution;
    /** Счёт главной книги */
    int score;
    /** Дата регистрации */
    LocalDate DateRegistration;
}
