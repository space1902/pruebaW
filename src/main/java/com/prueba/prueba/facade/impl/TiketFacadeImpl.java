package com.prueba.prueba.facade.impl;

import com.prueba.prueba.bo.TiketBO;
import com.prueba.prueba.bo.TiketResponseBO;
import com.prueba.prueba.facade.TiketFacade;
import com.prueba.prueba.services.TiketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TiketFacadeImpl implements TiketFacade {

    private final TiketService tiketService;

    @Override
    public List<TiketResponseBO> getTiket(int page, int size) {
        return tiketService.getEmployees(page, size);
    }

    @Override
    public TiketResponseBO getTiketById(Long id) {
        return tiketService.findById(id);
    }

    @Override
    public TiketResponseBO createTiket(TiketBO tiketBo) {
        return tiketService.create(tiketBo);
    }

    @Override
    public TiketResponseBO updateTiket(TiketBO tiketBo, Long id) {
        return tiketService.update(id, tiketBo);
    }
}
