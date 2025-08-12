package com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.handler;

import com.onclass.ccamilo.com.app.technologyservice.domain.api.TechnologyServicePort;
import com.onclass.ccamilo.com.app.technologyservice.domain.enums.ErrorMessage;
import com.onclass.ccamilo.com.app.technologyservice.domain.exception.BusinessException;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.dto.TechnologyDTO;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.mapper.TechnologyDTOMapper;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.util.Constants;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.util.ErrorResponseDTO;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.util.SuccesResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class TechnologyHandler {

    private final TechnologyServicePort servicePort;
    private  final TechnologyDTOMapper technologyDTOMapper;

    public Mono<ServerResponse> create(ServerRequest request) {
        String messageId = getMessageId(request);

        return request.bodyToMono(TechnologyDTO.class)
                .flatMap(req -> servicePort.create(technologyDTOMapper.toDomain(req)))
                .map(technologyDTOMapper::toDto)
                .doOnSuccess(resp -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .bodyValue(new SuccesResponseDTO(ErrorMessage.TECHNOLOGY_CREATED_SUCCESS_MESSAGE.getMessage(), null)))
                .doOnError(ex -> log.error("Error creating technology. messageId={}", messageId, ex))
                .onErrorResume(BusinessException.class, ex ->
                        buildError(HttpStatus.BAD_REQUEST, messageId, ErrorMessage.VALIDATION_ERROR)
                )
                .onErrorResume(TechnicalException.class, ex ->
                        buildError(HttpStatus.INTERNAL_SERVER_ERROR, messageId, ErrorMessage.TECHNOLOGY_NAME_ALREADY_EXISTS)
                )
                .onErrorResume(Throwable.class, ex -> {
                    log.error("Unexpected error occurred for messageId: {}", messageId, ex);
                    return buildError(HttpStatus.INTERNAL_SERVER_ERROR, messageId, ErrorMessage.VALIDATION_ERROR);
                })



    }

    private String getMessageId(ServerRequest req) {
        return req.headers().firstHeader(Constants.X_MESSAGE_ID);
    }

    private Mono<ServerResponse> buildError(HttpStatus status, String messageId, ErrorMessage errorMessage) {
        return ServerResponse
                .status(status)
                .bodyValue(
                        new ErrorResponseDTO(
                                status.name(), // Aquí pones el tipo de error (BAD_REQUEST, INTERNAL_SERVER_ERROR, etc.)
                                "%s (messageId=%s)".formatted(errorMessage.getMessage(), messageId) // Mensaje del enum
                        )
                );
    }


}
