package com.example.serviceexpensesincome1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/** Cущность услуги */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Service {
    /** Номер услуги */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idService;
    /** Категория услуги */
    String nameService;
}
