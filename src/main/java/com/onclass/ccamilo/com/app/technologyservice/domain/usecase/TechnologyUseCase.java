package com.onclass.ccamilo.com.app.technologyservice.domain.usecase;

import com.onclass.ccamilo.com.app.technologyservice.domain.api.TechnologyServicePort;
import com.onclass.ccamilo.com.app.technologyservice.domain.enums.ErrorMessage;
import com.onclass.ccamilo.com.app.technologyservice.domain.exception.BusinessException;
import com.onclass.ccamilo.com.app.technologyservice.domain.exception.TechnologyAlreadyExistsException;
import com.onclass.ccamilo.com.app.technologyservice.domain.model.Technology;
import com.onclass.ccamilo.com.app.technologyservice.domain.spi.TechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class TechnologyUseCase implements TechnologyServicePort {

    private final TechnologyPersistencePort persistence;

    @Override
    public Mono<Technology> create(Technology technology) {
        if (technology == null
                || technology.nombre() == null || technology.nombre().isBlank()
                || technology.descripcion() == null || technology.descripcion().isBlank()) {
            return Mono.error(new BusinessException(ErrorMessage.VALIDATION_ERROR));
        }

        final String nombre = technology.nombre().trim();
        final String descripcion = technology.descripcion().trim();

        return persistence.existsByNombre(nombre)
                .flatMap(exists-> exists ? Mono.error(new TechnologyAlreadyExistsException(ErrorMessage.TECHNOLOGY_NAME_ALREADY_EXISTS))
                        : persistence.save(new Technology(null, nombre,descripcion)));

    }

    @Override
    public Flux<Technology> list() {
        return persistence.findAll();
    }
}
