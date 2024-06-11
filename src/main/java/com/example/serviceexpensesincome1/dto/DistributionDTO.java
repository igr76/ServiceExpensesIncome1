package com.example.serviceexpensesincome.dto;

import java.util.Date;

public class DistributionDTO {
    String company;
    /** Номер счета */
    int idScore;
    /** Позиция счета */
    int idBuilding;
    /** Год счета */
    Date accountYear;
    /** Номер позиции распределения */
    int numberPosition;
    /** Дата отражения счета в учётной системе */
    Date dateAccount;
    /** id договора */
    int idContract;
    /** ID услуги */
    int idService;
    /** Класс услуги*/
    String classService;
    /** Здание */
    String Building;
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
    int Score;
}
