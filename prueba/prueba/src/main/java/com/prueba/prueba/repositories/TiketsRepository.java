package com.prueba.prueba.repositories;

import com.prueba.prueba.models.TiketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiketsRepository extends JpaRepository<TiketEntity, Long>  {

}