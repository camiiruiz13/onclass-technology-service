package com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.persistence.repository;

import com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.persistence.entity.TechnologyEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TechnologyR2dbcRepository  extends ReactiveCrudRepository<TechnologyEntity, Long> {
    @Query("SELECT  EXISTS(SELECT  1 FROM TECNOLOGIAS WHERE nombre = :nombre)")
    Mono<Boolean> existsByNombre(String nombre);
}
