package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
/** ВЕЩ основые средства */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ToolsDTO {
    /** ID tool */
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
    String beginningOfOwnershipUnion;
    /** Дата окончания действия связи с зданием */
    String endOfOwnershipUnion;
    /** Дата ввода в эксплуатацию */
    String beginningOfOperation;
    /** Дата выбытия*/
    String endOfOperation;

    /** Площадь */
    int square;

    /** Единица измерения площади */
    Unit unitOfArea;
}
