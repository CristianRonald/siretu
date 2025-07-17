package com.siretu.lugares.service;

import com.siretu.lugares.client.NlpClient;
import com.siretu.lugares.dao.LugarTuristicoRepository;
import com.siretu.lugares.dto.LugaresRequest;
import com.siretu.shared_dto.dto.ScrappingDTO;
import com.siretu.lugares.model.LugarTuristico;

import com.siretu.shared_dto.dto.LugarDTO;
import com.siretu.shared_dto.dto.LugarTuristicoDTO;
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

  public List<ScrappingDTO> getScrapping() {
    return scrapping.getLugaresFromYtuQuePlanes();
  }

  public LugarTuristico getOneLugarTuristico(MessageDTO msg) {
    LugarDTO lugares = nlpClient.mostrarLugar(msg);
    LugarTuristico lt = new LugarTuristico();
    lt.setLocalidad(lugares.getEntitie().getLocalidad());
    lt.setEmbedding(lugares.getEmbedding());
    lt.setTipo(lugares.getEntitie().getTipo());
    // lt.setTitle(l.getTitle());
    // lt.setDescripcion(l.getDescripcion());
    // LugarTuristicoRepository.save(lt);
    return lt;
  }

  public List<LugarTuristico> procesarTexto(LugaresRequest lr) {
    // List<ScrappingDTO> scra = scrapping.getLugaresFromYtuQuePlanes();
    List<ScrappingDTO> scra = lr.getMessage();
    List<LugarTuristico> llt = new ArrayList<>();
    System.out.println(scra.size());
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
      LugarTuristicoRepository.insertarLugar(lt, i);
      llt.add(lt);
    }

    return llt;
  }

  public List<LugarTuristicoDTO> searchLugares(MessageDTO messageDTO) {

    LugarDTO lugar = nlpClient.mostrarLugar(messageDTO);
    return LugarTuristicoRepository.buscarSimilares(lugar.getEmbedding(), 5);
  }
}
