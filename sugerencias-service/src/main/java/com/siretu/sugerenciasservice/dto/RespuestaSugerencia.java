package com.siretu.sugerenciasservice.dto;

import java.util.List;

import com.siretu.sugerenciasservice.model.Sugerencia;

/**
 * RespuestaSugerencia
 */
public class RespuestaSugerencia {

  List<Sugerencia> sugerencias;

  public List<Sugerencia> getSugerencias() {
    return this.sugerencias;
  }

  public void setSugerencias(List<Sugerencia> sugerencias) {
    this.sugerencias = sugerencias;
  }
}
