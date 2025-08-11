package com.onclass.ccamilo.com.app.technologyservice.domain.spi;

import com.onclass.ccamilo.com.app.technologyservice.domain.model.Technology;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TechnologyPersistencePort {
    Mono<Technology> save(Technology technology);
    Mono<Boolean> existsByNombre(String nombre);
    Flux<Technology> findAll();
}
