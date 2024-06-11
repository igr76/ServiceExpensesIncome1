package com.example.serviceexpensesincome.dto;

import java.util.Date;

public class ScoreDTO {
    /** Номер счета */
    int idScore;
    /** Позиция счета */
    int idBuilding;
    /** Год счета */
    Date accountYear;
    /** ID услуги */
    int idService;
    /** Номер договора */
    int contractNumber;
    /** Дата отражения счета в учётной системе */
    Date dateAccount;
    /** Объем оказанной услуги */
    int sizeService;
    /** Стоимость без НДС */
    int costNoNDS;
}
