package com.onclass.ccamilo.com.app.technologyservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Technology {
    private Long uniqueId;
    private String nombre;
    private String descripcion;
}
