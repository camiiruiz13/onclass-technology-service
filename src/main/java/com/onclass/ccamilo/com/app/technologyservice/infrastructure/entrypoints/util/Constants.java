package com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    public static final String BEAN_METHOD_CREATE_TECHNOLOGY = "create";
    public static final String BEAN_METHOD_LIST_TECHNOLOGY = "list";
    public static final String OP_CREATE_TECHNOLOGY_SUMMARY="Crear tecnología";
    public static final String OP_LIST_TECHNOLOGY_SUMMARY="Listar tecnologias";
    public static final String OP_CREATE_TECHNOLOGY_DESCRIPTION="Crea una nueva tecnología";
    public static final String OP_LIST_TECHNOLOGY_DESCRIPTION="Obtiene listado completo de tecnologias";
    public static final String TECHNOLOGY_ERROR = "Error on Technology - [ERROR]";
    public  static final String X_MESSAGE_ID = "X-Message-Id";

    public static final String OPERATION_ID_CREATE_TECHNOLOGY = "createTechnology";
    public static final String OPERATION_ID_LIST_TECHNOLOGY = "listTechnologies";

    //constantes del DTO
    public static final String SCHEMA_NAME = "Objeto de technology";
    public static final String SCHEMA_DESCRIPTION = "Objeto de transferencia para registrar y consultar tecnologías en el servicio de gestión tecnológica";

    // Mensajes de error
    public static final String NAME_REQUIRED = "El nombre de la tecnología es obligatorio";
    public static final String DESCRIPTION_MAX_LENGTH = "La descripción no puede superar los 255 caracteres";
    public static final String NAME_MAX_LENGTH = "El nombre no puede superar los 100 caracteres";

    // Descripciones Swagger/OpenAPI
    public static final String NAME_DESCRIPTION = "Nombre de la tecnología";
    public static final String DESCRIPTION_DESCRIPTION = "Descripción de la tecnología";

    // Ejemplos Swagger/OpenAPI
    public static final String NAME_EXAMPLE = "Java";
    public static final String DESCRIPTION_EXAMPLE = "Lenguaje de programación orientado a objetos";

    //Maximo valores
    public static final int MAX_LENGTH_NAME = 100;
    public static final int MAX_LENGTH_DESCRIPTION = 255;

    //Codigo responses
    public static final String OK = "200";
    public static final String CREATED = "201";
    public static final String BAD_REQUEST = "400";
    public static final String UNAUTHORIZED = "401";
    public static final String FORBIDDEN = "403";
    public static final String NOT_FOUND = "404";
    public static final String INTERNAL_SERVER_ERROR = "500";

    public static final String RESPONSE_200_DESC = "Operación realizada correctamente.";
    public static final String RESPONSE_201_DESC = "Tecnología creada correctamente";
    public static final String RESPONSE_400_DESC = "Error de validación";
    public static final String RESPONSE_401_DESC = "Token inválido o no enviado.";
    public static final String RESPONSE_403_DESC = "Acceso denegado: no tiene permisos suficientes.";
    public static final String RESPONSE_404_DESC = "Recurso no encontrado.";
    public static final String RESPONSE_500_DESC = "Error de validación";



}
