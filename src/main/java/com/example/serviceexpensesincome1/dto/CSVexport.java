package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
/** DTO распределения счетов выходные данные */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CSVexport {
    /** Компания */
    String company;
    /** Год счета */
    String accountYear;
    /** Номер счета */
    int idScore;
    /** Позиция счета */
    int categoryScore;
    /** id договора */
    int idContract;
    /** ID услуги */
    int idService;
    /** Дата отражения счета в учётной системе */
    String dateAccount;
    /**Стоимость без НДС */
    int moneyNoNDS;
}
