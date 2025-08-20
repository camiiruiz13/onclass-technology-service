package com.onclass.ccamilo.com.app.technologyservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    ERROR_EXCEPTION("Error interno del sistema."),
    TECHNOLOGY_NAME_ALREADY_EXISTS("El nombre de la tecnología ya existe"),
    NO_TECHNOLOGIES_FOUND("No se encontraron tecnologías registradas."),
    TECHNOLOGIES_LIST_SUCCESS("Listado de tecnologías exitoso"),
    TECHNOLOGY_CREATED_SUCCESS_MESSAGE("Tecnología creada correctamente"),
    VALIDATION_ERROR("Error de validación");

    private final String message;
}
