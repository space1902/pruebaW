package com.prueba.prueba.controller;

import com.prueba.prueba.bo.TiketBO;
import com.prueba.prueba.bo.TiketResponseBO;
import com.prueba.prueba.dto.request.TiketRequestDTO;
import com.prueba.prueba.dto.response.ApiResponseDTO;
import com.prueba.prueba.dto.response.TiketResponseDTO;
import com.prueba.prueba.facade.TiketFacade;
import com.prueba.prueba.mapper.TiketMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/tiket")
@AllArgsConstructor
public class TiketController {

    private final TiketMapper tiketMapper;

    private final TiketFacade facade;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponseDTO<TiketResponseDTO>> getTiketById(
            @Validated @PathVariable Long id) {
        TiketResponseBO tiketResponseBo = facade.getTiketById(id);
        TiketResponseDTO tiketResponseDto = tiketMapper.fromTiketResponseDtoToBo(tiketResponseBo);


        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDTO.<TiketResponseDTO>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Busqueda exitosa")
                        .code(tiketResponseBo != null ? "OK" : "FALLO")
                        .body(tiketResponseDto)
                        .build());
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponseDTO<List<TiketResponseDTO> >> getTiket(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<TiketResponseBO> tiketResponseBOPage = facade.getTiket(page, size);
        List<TiketResponseDTO> tiketResponseDtoPage = tiketMapper.fromTiketResponseDtoPageToBo(tiketResponseBOPage);

        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDTO.<List<TiketResponseDTO> >builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Busqueda exitosa")
                        .code(!tiketResponseDtoPage.isEmpty() ? "OK" : "SIN REGISTROS")
                        .body(tiketResponseDtoPage)
                        .build());
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ApiResponseDTO<TiketResponseDTO>> createTiket(
            @Validated @RequestBody TiketRequestDTO visaCardRequestDTO) {
        TiketBO tiketBo = tiketMapper.fromTiketDtoToBo(visaCardRequestDTO);
        TiketResponseBO tiketResponseBo = facade.createTiket(tiketBo);
        TiketResponseDTO tiketResponseDto = tiketMapper.fromTiketResponseDtoToBo(tiketResponseBo);


        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(ApiResponseDTO.<TiketResponseDTO>builder()
                        .statusCode(HttpStatus.ACCEPTED.value())
                        .message("Busqueda exitosa")
                        .code(tiketResponseBo != null ? "OK" : "FALLO")
                        .body(tiketResponseDto)
                        .build());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponseDTO<TiketResponseDTO>> updateTiket(
            @Validated @PathVariable Long id,
            @Validated @RequestBody TiketRequestDTO visaCardRequestDTO) {
        TiketBO tiketBo = tiketMapper.fromTiketDtoToBo(visaCardRequestDTO);
        TiketResponseBO tiketResponseBo = facade.updateTiket(tiketBo, id);
        TiketResponseDTO tiketResponseDto = tiketMapper.fromTiketResponseDtoToBo(tiketResponseBo);


        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDTO.<TiketResponseDTO>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Edicion exitosa")
                        .code(tiketResponseBo != null ? "OK" : "FALLO")
                        .body(tiketResponseDto)
                        .build());
    }
}
