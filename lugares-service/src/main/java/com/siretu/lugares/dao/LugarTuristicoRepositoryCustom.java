package com.siretu.lugares.dao;

import java.util.List;

import com.siretu.lugares.model.LugarTuristico;

public interface LugarTuristicoRepositoryCustom {
  void insertarLugar(LugarTuristico lugarTuristico, int id);

  List<LugarTuristico> buscarSimilares(float[] embedding, int limite);
}
