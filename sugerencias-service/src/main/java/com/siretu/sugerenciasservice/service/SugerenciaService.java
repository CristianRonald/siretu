package com.siretu.sugerenciasservice.service;

import org.springframework.stereotype.Service;

import com.siretu.sugerenciasservice.dto.MensajeRecibido;
import com.siretu.sugerenciasservice.dto.RespuestaSugerencia;

@Service
public class SugerenciaService {

  public RespuestaSugerencia generarSugerencia(MensajeRecibido mr) {
    RespuestaSugerencia rs = new RespuestaSugerencia();
    return rs;
  }
}
