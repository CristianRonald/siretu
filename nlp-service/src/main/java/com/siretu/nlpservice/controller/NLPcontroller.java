package com.siretu.nlpservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siretu.nlpservice.dto.FullLugaresRequest;
import com.siretu.nlpservice.service.NLPservice;

import com.siretu.shared_dto.dto.LugarDTO;
import com.siretu.shared_dto.dto.MessageDTO;

@RestController
@RequestMapping("api/nlp")
public class NLPcontroller {

  @Autowired
  NLPservice nlPservice;

  @PostMapping
  public LugarDTO mostrarLugar(@RequestBody MessageDTO m) {
    try {
      return nlPservice.mostrarLugar(m);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  @PostMapping("/lugar")
  public List<LugarDTO> getFullLugares(@RequestBody FullLugaresRequest fr) {

    try {
      System.out.println("hola");
      return nlPservice.getFullLugares(fr.getMessage());
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }

  }

}
