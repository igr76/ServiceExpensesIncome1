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
    Unit unitOfArea;
}
