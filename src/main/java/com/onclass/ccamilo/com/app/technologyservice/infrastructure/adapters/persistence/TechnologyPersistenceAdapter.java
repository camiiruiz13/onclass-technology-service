package com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.persistence;

import com.onclass.ccamilo.com.app.technologyservice.domain.model.Technology;
import com.onclass.ccamilo.com.app.technologyservice.domain.spi.TechnologyPersistencePort;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.persistence.mapper.TechnologyEntityMapper;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.persistence.repository.TechnologyR2dbcRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TechnologyPersistenceAdapter implements TechnologyPersistencePort {
    private final TechnologyR2dbcRepository repository;
    private final TechnologyEntityMapper mapper;

    @Override
    public Mono<Technology> save(Technology technology) {
        return repository.save(mapper.toTechnologyEntity(technology))
                .map(mapper::toModel);
    }

    @Override
    public Mono<Boolean> existsByNombre(String nombre) {
        return repository.countByNombre(nombre).map(c -> c > 0);
    }

    @Override
    public Flux<Technology> findAll() {
        return repository.findAll().map(mapper::toModel);
    }
}
