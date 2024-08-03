package com.prueba.prueba.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDTO<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -8097821240224209802L;

    @JsonProperty(value = "status_code")
    private Integer statusCode;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "code")
    private String code;

    @JsonProperty(value = "body")
    private transient T body;
}