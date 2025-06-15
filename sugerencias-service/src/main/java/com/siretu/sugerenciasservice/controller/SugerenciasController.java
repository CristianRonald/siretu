package com.siretu.sugerenciasservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siretu.sugerenciasservice.dto.MensajeRecibido;
import com.siretu.sugerenciasservice.dto.RespuestaSugerencia;
import com.siretu.sugerenciasservice.service.SugerenciaService;

@RestController
@RequestMapping("api/sugerencia")
public class SugerenciasController {

  @Autowired
  SugerenciaService sugerenciaService;

  @PostMapping
  public RespuestaSugerencia procesar(@RequestBody MensajeRecibido mensajeRecibido) {
    return sugerenciaService.generarSugerencia(mensajeRecibido);
  }
}
