package com.siretu.sugerenciasservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siretu.shared_dto.dto.LugarTuristicoDTO;
import com.siretu.shared_dto.dto.MessageDTO;
import com.siretu.sugerenciasservice.client.LugaresClient;

@Service
public class SugerenciaService {
  @Autowired
  LugaresClient lugaresClient;

  public String generarSugerencia(MessageDTO msg) {
    List<LugarTuristicoDTO> llt = lugaresClient.searchLugares(msg);
    return this.createMessage(llt);
  }

  private List<LugarTuristicoDTO> similitud(LugarTuristicoDTO lt, List<LugarTuristicoDTO> llt) {

    return llt.stream().filter(p -> lt.getTipo().equals(p.getTipo())).collect(Collectors.toList());
  }

  private String createMessage(List<LugarTuristicoDTO> llt) {
    String message = "";
    if (llt.get(0).getDistancia() > 0.7) {
      return "No se encontro una sugerencia relevante para tu consulta.";
    }
    for (LugarTuristicoDTO lugarTuristicoDTO : llt) {
      if (lugarTuristicoDTO.getDistancia() > 0.7) {
        message = "Tambien te puede interesar: " + lugarTuristicoDTO.getTitle() + "donde puedes encontrar "
            + lugarTuristicoDTO.getDescripcion();
      }
      message = "Podemos ofrecerte recomendarte lo siguiente: " + lugarTuristicoDTO.getTitle()
          + "donde  puedes encontrar"
          + lugarTuristicoDTO.getDescripcion();
    }
    return message;
  }
}
