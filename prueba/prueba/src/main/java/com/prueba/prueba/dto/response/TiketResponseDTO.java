package com.prueba.prueba.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
public class TiketResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4447341372096008719L;

    @JsonProperty("id_tiket")
    private Long idTiket;

    @JsonProperty("id_user")
    private Long idUser;

    @JsonProperty("create_date")
    private String createDate;

    @JsonProperty("update_date")
    private String updateDate;

    @JsonProperty("status")
    private String status;
}
