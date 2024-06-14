package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
/** DTO договоров */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContractDTO {
    /** Номер договоров */
    int id;
    /** Позиция договоров */
    int idBuilding;
}
