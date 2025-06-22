package com.siretu.sugerenciasservice.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siretu.sugerenciasservice.dto.MensajeRecibido;
import com.siretu.sugerenciasservice.dto.RespuestaSugerencia;

@Service
public class SugerenciaService {

  @Autowired
  Scrapping scrapping;

  public RespuestaSugerencia generarSugerencia(MensajeRecibido mr) {
    try {
      RespuestaSugerencia sugerencia = new RespuestaSugerencia();
      scrapping.getLugarTuristico("/destinos/huanuco");
      sugerencia.setSugerencias(scrapping.genFullSugerencias());
      System.out.println(sugerencia.getSugerencias());
      return sugerencia;
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}
