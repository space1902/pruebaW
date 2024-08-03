package com.prueba.prueba.services.impl;

import com.prueba.prueba.bo.TiketBO;
import com.prueba.prueba.bo.TiketResponseBO;
import com.prueba.prueba.mapper.TiketMapper;
import com.prueba.prueba.models.TiketEntity;
import com.prueba.prueba.repositories.TiketsRepository;
import com.prueba.prueba.services.TiketService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TiketImpl implements TiketService {


    private final TiketsRepository repository;

    private final TiketMapper tiketMapper;

    @Override
    public TiketResponseBO findById(Long id) {
        TiketEntity tiketEntity = getById(id);
        return tiketMapper.fromTiketEntityToBo(tiketEntity);
    }

    @Override
    public List<TiketResponseBO> getEmployees(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TiketEntity> tiketEntityPage = repository.findAll(pageable);
        return tiketMapper.fromTiketEntityPageToBo(tiketEntityPage);
    }

    @Override
    public TiketResponseBO create(TiketBO tiketBo) {
        TiketEntity tiketEntity = tiketMapper.fromTiketBoToEntity(tiketBo);
        TiketEntity tiketEntitySave = repository.save(tiketEntity);
        return tiketMapper.fromTiketEntityToBo(tiketEntitySave);
    }

    @Override
    public TiketResponseBO update(Long id, TiketBO tiketBo) {
        TiketEntity tiketEntity = getById(id);
        tiketMapper.fromBoToEntity(tiketBo, tiketEntity);
        TiketEntity tiketEntitySave = repository.save(tiketEntity);
        return tiketMapper.fromTiketEntityToBo(tiketEntitySave);
    }

    private TiketEntity getById(long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                String.format("AccountDebitCardEntity with ID %d does not exist.", id)));
    }
}
