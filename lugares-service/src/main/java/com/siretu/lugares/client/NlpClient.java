package com.siretu.lugares.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.siretu.shared_dto.dto.LugarDTO;
import com.siretu.shared_dto.dto.MessageDTO;
import com.siretu.lugares.dto.LugaresRequest;

@FeignClient(name = "nlp-service")
public interface NlpClient {
  @PostMapping("api/nlp/lugar")
  List<LugarDTO> getFullLugares(@RequestBody LugaresRequest lugaresRequest);

  @PostMapping("api/nlp")
  LugarDTO mostrarLugar(@RequestBody MessageDTO messageDTO);
}
