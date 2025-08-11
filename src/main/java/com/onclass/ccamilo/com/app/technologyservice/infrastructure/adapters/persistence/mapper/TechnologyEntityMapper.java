package com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.persistence.mapper;

import com.onclass.ccamilo.com.app.technologyservice.domain.model.Technology;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.adapters.persistence.entity.TechnologyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnologyEntityMapper {

    Technology toModel(TechnologyEntity technologyEntity);
    TechnologyEntity toTechnologyEntity(Technology technology);
}
