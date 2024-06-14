package com.example.serviceexpensesincome1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
/** Связь договора и здание */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Union {
    /** ID договора */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdContract;
    /** ID здания */
    int idBuilding;
    /** Дата начала действия связи */
    Date beginningOfUnion;
    /** Дата окончания действия связи*/
    Date endOfUnion;

}
