package com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints;

import com.onclass.ccamilo.com.app.technologyservice.infrastructure.constants.EndPointApi;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.dto.TechnologyDTO;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.handler.TechnologyHandler;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.util.Constants;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.util.ErrorResponseDTO;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.util.SuccesResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterRest {

    @Bean
    @RouterOperation(path = EndPointApi.CREATE_TECHNOLOGY,
    produces = {MediaType.APPLICATION_JSON_VALUE},
    beanClass = TechnologyHandler.class,
    beanMethod = Constants.BEAN_METHOD_CREATE_TECHNOLOGY,
    operation = @Operation(
            operationId = Constants.OPERATION_ID_CREATE_TECHNOLOGY,
            summary = Constants.OP_CREATE_TECHNOLOGY_SUMMARY,
            description = Constants.OP_CREATE_TECHNOLOGY_DESCRIPTION,
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = TechnologyDTO.class))
            ),
            responses = {
                    @ApiResponse(
                            responseCode = Constants.CREATED,
                            description = Constants.RESPONSE_201_DESC,
                            content = @Content(schema = @Schema(implementation = SuccesResponseDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = Constants.BAD_REQUEST,
                            description = Constants.RESPONSE_400_DESC,
                            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = Constants.INTERNAL_SERVER_ERROR,
                            description = Constants.RESPONSE_500_DESC,
                            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))
                    )
            }
    ))
    RouterFunction<ServerResponse> routerFunction(TechnologyHandler technologyHandler) {
        return RouterFunctions.route(RequestPredicates.POST(EndPointApi.CREATE_TECHNOLOGY), technologyHandler::create);
    }
}
