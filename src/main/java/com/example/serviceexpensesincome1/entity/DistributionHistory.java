package com.example.serviceexpensesincome1.entity;

import com.example.serviceexpensesincome1.dto.Type;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
/** Cущность история  распределения счетов */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "history")
@Entity
public class DistributionHistory {
    /**
     * id счетов
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    int id;
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
    int IdO;
    /** Класс основного средства */
    Type type;
    /** Признак Использования */
    boolean signExpenses;
    /** Распределенная сумма */
    int sizeDistribution;
    /** Счёт главной книги */
    int Score;
    /** Дата регистрации */
    @Column(name = "date_registration")
    LocalDate DateRegistration;
}
