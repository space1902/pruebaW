package com.prueba.prueba.facade;

import com.prueba.prueba.bo.TiketBO;
import com.prueba.prueba.bo.TiketResponseBO;

import java.util.List;

public interface TiketFacade {

    List<TiketResponseBO> getTiket(int page, int size);

    TiketResponseBO getTiketById (Long id);

    TiketResponseBO createTiket (TiketBO tiketBo);

    TiketResponseBO updateTiket (TiketBO tiketBo, Long id);
}
