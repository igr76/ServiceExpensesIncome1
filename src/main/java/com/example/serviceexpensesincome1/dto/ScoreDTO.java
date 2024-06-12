package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
/** DTO счетов */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
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
