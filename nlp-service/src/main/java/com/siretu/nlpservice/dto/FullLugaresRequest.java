package com.siretu.nlpservice.dto;

import java.util.ArrayList;
import java.util.List;

import com.siretu.shared_dto.dto.ScrappingDTO;

public class FullLugaresRequest {
  private List<ScrappingDTO> message = new ArrayList<>();

  public List<ScrappingDTO> getMessage() {
    return this.message;
  }

  public void setMessage(List<ScrappingDTO> message) {
    this.message = message;
  }
}
