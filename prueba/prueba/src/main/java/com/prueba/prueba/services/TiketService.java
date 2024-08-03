package com.prueba.prueba.services;

import com.prueba.prueba.bo.TiketBO;
import com.prueba.prueba.bo.TiketResponseBO;

import java.util.List;

public interface TiketService {

    TiketResponseBO findById(Long id);

    List<TiketResponseBO> getEmployees(int page, int size);

    TiketResponseBO create(TiketBO t);

    TiketResponseBO update(Long id, TiketBO t);

}
