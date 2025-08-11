package com.onclass.ccamilo.com.app.technologyservice.infrastructure.configuration;

import com.onclass.ccamilo.com.app.technologyservice.domain.spi.TechnologyPersistencePort;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.persistence.TechnologyPersistenceAdapter;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.persistence.mapper.TechnologyEntityMapper;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.persistence.repository.TechnologyR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PersistenceConfig {
    private final TechnologyR2dbcRepository technologyR2dbcRepository;
    private final TechnologyEntityMapper technologyEntityMapper;

    @Bean
    TechnologyPersistencePort technologyPersistencePort(){
        return new TechnologyPersistenceAdapter(technologyR2dbcRepository, technologyEntityMapper);
    }

}
