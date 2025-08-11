package com.onclass.ccamilo.com.app.technologyservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    TECHNOLOGY_NAME_ALREADY_EXISTS("El nombre de la tecnología ya existe"),
    VALIDATION_ERROR("Error de validación");

    private final String message;
}
