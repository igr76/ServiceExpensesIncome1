package com.example.serviceexpensesincome.dto;

import java.util.Date;

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
    Unit UnitOfArea;
}
