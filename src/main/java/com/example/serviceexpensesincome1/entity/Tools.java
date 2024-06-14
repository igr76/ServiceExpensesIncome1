package com.example.serviceexpensesincome1.entity;

import com.example.serviceexpensesincome1.dto.Type;
import com.example.serviceexpensesincome1.dto.Unit;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
/** Cущность основые средства */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Tools {
    /** ID основного средства */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    /** Класс основного средства */
    Type type;
    /** Признак Использования */
    boolean signExpenses;
    /** Признак  в
     аренде, не в аренде */
    boolean signRent;
    /** ID здания */
    int IdBuilding;
    /** Дата начала действия связи с зданием*/
    Date beginningOfOwnershipUnion;
    /** Дата окончания действия связи с зданием */
    Date endOfOwnershipUnion;
    /** Дата ввода в эксплуатацию */
    Date beginningOfOperation;
    /** Дата выбытия*/
    Date endOfOperation;

    /** Площадь */
    int square;

    /** Единица измерения площади */
    Unit UnitOfArea;
}
