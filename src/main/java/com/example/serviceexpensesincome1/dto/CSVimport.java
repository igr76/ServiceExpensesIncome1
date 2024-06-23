package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/** DTO распределения счетов входные данные */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CSVimport {
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
