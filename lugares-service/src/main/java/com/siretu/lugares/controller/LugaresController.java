package com.siretu.lugares.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siretu.lugares.dto.LugaresRequest;
import com.siretu.lugares.model.LugarTuristico;
import com.siretu.lugares.service.LugaresService;

@RestController
@RequestMapping("api/lugares")
public class LugaresController {
  @Autowired
  LugaresService lugaresService;

  @GetMapping
  public String getMessage() {
    return "hola";
  }

  @PostMapping("/scrapping")
  public List<LugarTuristico> getFullLugares(@RequestBody LugaresRequest lr) {
    return lugaresService.procesarTexto(lr);
  }
}
