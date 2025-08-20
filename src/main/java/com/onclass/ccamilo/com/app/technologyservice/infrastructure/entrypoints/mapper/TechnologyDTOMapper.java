package com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.mapper;

import com.onclass.ccamilo.com.app.technologyservice.domain.model.Technology;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.dto.TechnologyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnologyDTOMapper {

    @Mapping(source = "idTechnology", target = "uniqueId")
    Technology toDomain(TechnologyDTO dto);

    @Mapping(source = "uniqueId", target = "idTechnology")
    TechnologyDTO toDto(Technology domain);

    List<TechnologyDTO> toDtos(List<Technology> domains);

}
