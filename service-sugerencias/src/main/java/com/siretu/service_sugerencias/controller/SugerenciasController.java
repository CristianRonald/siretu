<<<<<<< HEAD
package com.siretu.service_sugerencias.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siretu.service_sugerencias.dto.MensajeRecibido;
import com.siretu.service_sugerencias.dto.RespuestaSugerencia;
import com.siretu.service_sugerencias.service.SugerenciaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("sugerencia")
@RequiredArgsConstructor
public class SugerenciasController {

  private final SugerenciaService sugerenciaService;

  @PostMapping
  public RespuestaSugerencia procesar(@RequestBody MensajeRecibido mensajeRecibido) {
    return sugerenciaService.generarSugerencia(mensajeRecibido);
  }
}
=======
package com.siretu.service_sugerencias.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siretu.service_sugerencias.dto.MensajeRecibido;
import com.siretu.service_sugerencias.dto.RespuestaSugerencia;
import com.siretu.service_sugerencias.service.SugerenciaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("sugerencia")
@RequiredArgsConstructor
public class SugerenciasController {

  private final SugerenciaService sugerenciaService;

  @PostMapping
  public RespuestaSugerencia procesar(@RequestBody MensajeRecibido mensajeRecibido) {
    return sugerenciaService.generarSugerencia(mensajeRecibido);
  }
}
>>>>>>> 846f88161ea4aaf513941fd9b73c382eacd7b663
