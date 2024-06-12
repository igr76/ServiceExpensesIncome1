package com.example.serviceexpensesincome1.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
/** DTO услуги */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceDTO {
    /** Номер услуги */
    int idService;
    /** Категория услуги */
    String nameService;
}
