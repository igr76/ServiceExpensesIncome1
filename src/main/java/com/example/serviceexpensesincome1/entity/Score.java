package com.example.serviceexpensesincome1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
/** Cущность  счетов */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** Номер счета */
    int idScore;
    /** Позиция счета */
    int idBuilding;
    /** Год счета */
    LocalDate accountYear;
    /** ID услуги */
    int idService;
    /** Номер договора */
    int contractNumber;
    /** Дата отражения счета в учётной системе */
    LocalDate dateAccount;
    /** Объем оказанной услуги */
    int sizeService;
    /** Стоимость без НДС */
    int costNoNds;
}
