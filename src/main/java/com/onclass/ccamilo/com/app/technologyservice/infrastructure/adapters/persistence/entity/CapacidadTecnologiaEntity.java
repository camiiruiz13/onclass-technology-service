package com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("CAPACIDAD_TECNOLOGIAS")
public class CapacidadTecnologiaEntity {

    @Id
    @Column("UniqueID")
    private Long uniqueId;

    @Column("id_tecnologia")
    private Long idTecnologia;

    @Column("id_capacidad")
    private Long idCapacidad;
}
