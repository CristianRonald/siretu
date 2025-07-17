package com.siretu.lugares.dao;

import java.util.List;

import com.siretu.lugares.model.LugarTuristico;
import com.siretu.shared_dto.dto.LugarTuristicoDTO;

public interface LugarTuristicoRepositoryCustom {
  void insertarLugar(LugarTuristico lugarTuristico, int id);

  List<LugarTuristicoDTO> buscarSimilares(float[] embedding, int limite);
}
