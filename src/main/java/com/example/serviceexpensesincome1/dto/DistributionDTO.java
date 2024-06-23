package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
/** DTO распределения счетов */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DistributionDTO {
    /** Компания */
    String company;
    /** Номер счета */
    int idScore;
    /** Позиция счета */
    int idBuilding;
    /** Год счета */
    String accountYear;
    /** Номер позиции распределения */
    int numberPosition;
    /** Дата отражения счета в учётной системе */
    String dateAccount;
    /** id договора */
    int idContract;
    /** ID услуги */
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
}
