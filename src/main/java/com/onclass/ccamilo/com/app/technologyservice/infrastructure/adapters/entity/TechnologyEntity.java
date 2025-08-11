package com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("TECNOLOGIAS")
public class TechnologyEntity {

    @Id
    @Column("UniqueID")
    private Long uniqueId;

    @Column("nombre")
    private String nombre;

    @Column("descripcion")
    private String descripcion;
}
