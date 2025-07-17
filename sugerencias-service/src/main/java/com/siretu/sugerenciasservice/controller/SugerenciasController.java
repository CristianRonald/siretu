package com.siretu.sugerenciasservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siretu.shared_dto.dto.MessageDTO;
import com.siretu.sugerenciasservice.service.SugerenciaService;

@RestController
@RequestMapping("api/sugerencia")
public class SugerenciasController {

  @Autowired
  SugerenciaService sugerenciaService;

  @PostMapping
  public String procesarMensaje(@RequestBody MessageDTO messageDTO) {
    return sugerenciaService.generarSugerencia(messageDTO);
  }
}
