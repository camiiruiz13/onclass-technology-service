package com.onclass.ccamilo.com.app.technologyservice.infrastructure.constants;

public class EndPointApi {

    private EndPointApi() {
        throw new IllegalStateException("Utility class");
    }

    public static final String BASE_PATH = "/api/technologies";
    public static final String CREATE_TECHNOLOGY = BASE_PATH;
    public static final String LIST_TECHNOLOGIES = BASE_PATH;
}
