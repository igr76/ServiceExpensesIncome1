package com.example.serviceexpensesincome1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/** Cущность договоров */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Contract {
    /** Номер договоров */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idScore;
    /** Позиция договоров */
    int idBuilding;
}
