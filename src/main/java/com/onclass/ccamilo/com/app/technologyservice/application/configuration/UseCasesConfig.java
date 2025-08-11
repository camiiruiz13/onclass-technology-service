package com.onclass.ccamilo.com.app.technologyservice.application.configuration;

import com.onclass.ccamilo.com.app.technologyservice.domain.api.TechnologyServicePort;
import com.onclass.ccamilo.com.app.technologyservice.domain.spi.TechnologyPersistencePort;
import com.onclass.ccamilo.com.app.technologyservice.domain.usecase.TechnologyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UseCasesConfig {

    @Bean
    TechnologyServicePort technologyServicePort(TechnologyPersistencePort technologyPersistencePort) {
        return new TechnologyUseCase(technologyPersistencePort);
    }
}
