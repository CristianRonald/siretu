package com.siretu.nlpservice.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siretu.shared_dto.dto.EntitieDTO;
import com.siretu.shared_dto.dto.LugarDTO;
import com.siretu.shared_dto.dto.MessageDTO;
import com.siretu.shared_dto.dto.ScrappingDTO;

@Service
public class NLPservice {

  @Autowired
  Embedding embedding;

  @Autowired
  IntentClassifier intentClassifier;

  public LugarDTO mostrarLugar(MessageDTO message) {
    try {
      String m = limpiarTexto(message.getMessage());
      Map<String, String> entities = intentClassifier.extractEntities(m);

      EntitieDTO entitie = new EntitieDTO();
      ScrappingDTO scrappingDTO = new ScrappingDTO();
      scrappingDTO.setDescription(m);
      if (m.contains("%20")) {
        scrappingDTO.setTitle(m.split("%20")[0]);
        scrappingDTO.setDescription(m.split("%20")[1]);
      }
      entitie.setScrapingDTO(scrappingDTO);
      entitie.setLocated(entities.get("localidad"));
      entitie.setActividades(entities.get("actividad"));
      entitie.setTipo(entities.get("tipo"));

      LugarDTO lugarDTO = new LugarDTO();
      lugarDTO.setEmbedding(embedding.generateEmbedding(message));
      lugarDTO.setEntities(entitie);

      return lugarDTO;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public List<LugarDTO> getFullLugares(List<ScrappingDTO> sdto) {
    List<LugarDTO> lugares = new ArrayList<>();

    System.out.println(sdto.size());
    MessageDTO messageDTO = new MessageDTO();
    for (ScrappingDTO s : sdto) {
      messageDTO.setMessage(s.getTitle() + "%20" + s.getDescripcion());
      lugares.add(this.mostrarLugar(messageDTO));
    }
    return lugares;
  }

  private static String limpiarTexto(String texto) {
    if (texto == null)
      return null;

    String limpio = texto.toLowerCase();

    limpio = Normalizer.normalize(limpio, Normalizer.Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

    limpio = limpio.replaceAll("[^a-z0-9\\s]", ""); // solo letras, números y espacios

    limpio = limpio.trim().replaceAll("\\s{2,}", " ");

    return limpio;
  }
}
