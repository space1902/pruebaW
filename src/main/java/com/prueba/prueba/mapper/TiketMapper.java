package com.prueba.prueba.mapper;

import com.prueba.prueba.bo.TiketBO;
import com.prueba.prueba.bo.TiketResponseBO;
import com.prueba.prueba.dto.request.TiketRequestDTO;
import com.prueba.prueba.dto.response.TiketResponseDTO;
import com.prueba.prueba.models.TiketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = SPRING,
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface TiketMapper {

    TiketBO fromTiketDtoToBo(TiketRequestDTO tiketRequestDto);

    TiketResponseBO fromTiketEntityToBo (TiketEntity tiketEntity);

    List<TiketResponseBO> fromListTiketEntityToBo (List<TiketEntity> tiketEntity);

    TiketEntity fromTiketBoToEntity (TiketBO tiketBo);

    void fromBoToEntity(TiketBO updateBo, @MappingTarget TiketEntity entity);

    TiketResponseDTO fromTiketResponseDtoToBo (TiketResponseBO tiketResponseBo);

    List<TiketResponseBO> fromTiketEntityPageToBo (Page<TiketEntity> tiketEntityPage);

    List<TiketResponseDTO> fromTiketResponseDtoPageToBo (List<TiketResponseBO> tiketResponseBoPage);
}
