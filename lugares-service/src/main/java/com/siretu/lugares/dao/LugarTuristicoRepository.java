package com.siretu.lugares.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siretu.lugares.model.LugarTuristico;

@Repository
public interface LugarTuristicoRepository
    extends JpaRepository<LugarTuristico, Long>, LugarTuristicoRepositoryCustom {

}
