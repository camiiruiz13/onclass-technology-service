package com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.onclass.ccamilo.com.app.technologyservice.infrastructure.entrypoints.util.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Schema(
        name = Constants.SCHEMA_NAME,
        description = Constants.SCHEMA_DESCRIPTION
)
public class TechnologyDTO {

    @Schema(hidden = true)
    private Long idTechnology;

    @NotBlank(message = Constants.NAME_REQUIRED)
    @Size(max = Constants.MAX_LENGTH_NAME, message = Constants.NAME_MAX_LENGTH)
    @Schema(description = Constants.NAME_DESCRIPTION, example = Constants.NAME_EXAMPLE, maxLength = Constants.MAX_LENGTH_NAME)
    private String nombre;

    @Size(max = Constants.MAX_LENGTH_DESCRIPTION, message = Constants.DESCRIPTION_MAX_LENGTH)
    @Schema(description = Constants.DESCRIPTION_DESCRIPTION, example = Constants.DESCRIPTION_EXAMPLE , maxLength = Constants.MAX_LENGTH_DESCRIPTION)
    private String descripcion;
}
