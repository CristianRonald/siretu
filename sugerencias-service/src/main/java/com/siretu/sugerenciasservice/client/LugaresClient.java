package com.siretu.sugerenciasservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.siretu.shared_dto.dto.MessageDTO;
import com.siretu.shared_dto.dto.LugarTuristicoDTO;;

/**
 * LugaresClient
 */
@FeignClient(name = "lugares-service")
public interface LugaresClient {

  @PostMapping("api/lugares/one")
  public LugarTuristicoDTO getOneLugarTuristico(@RequestBody MessageDTO messageDTO);

  @PostMapping("api/lugares")
  public List<LugarTuristicoDTO> searchLugares(@RequestBody MessageDTO messageDTO);
}
