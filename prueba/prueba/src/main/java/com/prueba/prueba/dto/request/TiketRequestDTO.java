package com.prueba.prueba.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TiketRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4447341372096008719L;

    @Schema(name = "id_user", example = "1")
    @JsonProperty("id_user")
    @NotNull
    private Long idUser;

    @Schema(name = "create_date", example = "20/03/2024")
    @JsonProperty("create_date")
    private String createDate;

    @Schema(name = "update_date", example = "20/03/2024")
    @JsonProperty("update_date")
    private String updateDate;

    @Schema(name = "status", example = "abierto")
    @JsonProperty("status")
    @NotBlank
    private String status;
}
