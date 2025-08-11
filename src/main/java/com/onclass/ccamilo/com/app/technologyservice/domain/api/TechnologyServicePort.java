package com.onclass.ccamilo.com.app.technologyservice.domain.api;

import com.onclass.ccamilo.com.app.technologyservice.domain.model.Technology;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TechnologyServicePort {
    Mono<Technology> create(Technology technology);
    Flux<Technology> list();
}
