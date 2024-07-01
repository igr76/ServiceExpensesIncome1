package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/** DTO прогнозирования */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ForecastingDTO {
    /** Позиция счета */
    int idBuilding;
    /** Счёт главной книги */
    int nomberScore;
    /** депатамент */
    int department =1;
    /** сумма по месяцам */
    List<Integer> sumMonth;

}
