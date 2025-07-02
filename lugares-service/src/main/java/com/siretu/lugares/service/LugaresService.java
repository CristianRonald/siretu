package com.siretu.lugares.service;

import com.siretu.lugares.client.NlpClient;
import com.siretu.lugares.dao.LugarTuristicoRepository;
import com.siretu.lugares.dto.LugaresRequest;
import com.siretu.shared_dto.dto.ScrappingDTO;
import com.siretu.lugares.model.LugarTuristico;

import com.siretu.shared_dto.dto.LugarDTO;
import com.siretu.shared_dto.dto.MessageDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LugaresService {
  @Autowired
  private NlpClient nlpClient;

  @Autowired
  private Scrapping scrapping;

  @Autowired
  private LugarTuristicoRepository LugarTuristicoRepository;

  public List<LugarTuristico> procesarTexto() {
    LugaresRequest lr = new LugaresRequest();
    lr.setMessage(scrapping.getLugaresFromYtuQuePlanes());
    List<ScrappingDTO> scra = lr.getMessage();
    List<LugarTuristico> llt = new ArrayList<>();
    int i = 0;
    for (ScrappingDTO l : scra) {
      i++;
      System.out.println(i);
      MessageDTO msg = new MessageDTO();
      msg.setMessage(l.getDescripcion());
      LugarDTO lugares = nlpClient.mostrarLugar(msg);
      LugarTuristico lt = new LugarTuristico();
      lt.setLocalidad(lugares.getEntitie().getLocalidad());
      lt.setEmbedding(lugares.getEmbedding());
      lt.setTipo(lugares.getEntitie().getTipo());
      lt.setTitle(l.getTitle());
      lt.setDescripcion(l.getDescripcion());
      LugarTuristicoRepository.save(lt);
      llt.add(lt);
    }

    return llt;
  }

}
