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
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterRest {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = EndPointApi.CREATE_TECHNOLOGY,
                    method = RequestMethod.POST,
                    consumes = { MediaType.APPLICATION_JSON_VALUE },
                    produces = { MediaType.APPLICATION_JSON_VALUE },
                    beanClass = TechnologyHandler.class,
                    beanMethod = "create",
                    operation = @Operation(
                            operationId = Constants.OPERATION_ID_CREATE_TECHNOLOGY,
                            summary = Constants.OP_CREATE_TECHNOLOGY_SUMMARY,
                            description = Constants.OP_CREATE_TECHNOLOGY_DESCRIPTION,
                            requestBody = @RequestBody(
                                    required = true,
                                    content = @Content(schema = @Schema(implementation = TechnologyDTO.class))
                            ),
                            responses = {
                                    @ApiResponse(responseCode = Constants.CREATED,
                                            description = Constants.RESPONSE_201_DESC,
                                            content = @Content(schema = @Schema(implementation = SuccesResponseDTO.class))),
                                    @ApiResponse(responseCode = Constants.BAD_REQUEST,
                                            description = Constants.RESPONSE_400_DESC,
                                            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
                                    @ApiResponse(responseCode = Constants.INTERNAL_SERVER_ERROR,
                                            description = Constants.RESPONSE_500_DESC,
                                            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
                            }
                    )
            ),
            @RouterOperation(
                    path = EndPointApi.LIST_TECHNOLOGIES,
                    method = RequestMethod.GET,
                    produces = { MediaType.APPLICATION_JSON_VALUE },
                    beanClass = TechnologyHandler.class,
                    beanMethod = "list",
                    operation = @Operation(
                            operationId = Constants.OPERATION_ID_LIST_TECHNOLOGY,
                            summary = Constants.OP_LIST_TECHNOLOGY_SUMMARY,
                            description = Constants.OP_LIST_TECHNOLOGY_DESCRIPTION,
                            responses = {
                                    @ApiResponse(responseCode = Constants.OK,
                                            description = Constants.RESPONSE_200_DESC,
                                            content = @Content(schema = @Schema(implementation = SuccesResponseDTO.class))),
                                    @ApiResponse(responseCode = Constants.BAD_REQUEST,
                                            description = Constants.RESPONSE_400_DESC,
                                            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class))),
                                    @ApiResponse(responseCode = Constants.INTERNAL_SERVER_ERROR,
                                            description = Constants.RESPONSE_500_DESC,
                                            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> routerFunction(TechnologyHandler handler) {
        return RouterFunctions.route()
                .POST(EndPointApi.CREATE_TECHNOLOGY, handler::create)
                .GET(EndPointApi.LIST_TECHNOLOGIES, handler::list)
                .build();
    }
}
