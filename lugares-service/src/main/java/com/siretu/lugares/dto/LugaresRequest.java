package com.siretu.lugares.dto;

import java.util.List;

import com.siretu.shared_dto.dto.ScrappingDTO;

/**
 * NLPrequest
 */
public class LugaresRequest {

  private List<ScrappingDTO> message;

  public List<ScrappingDTO> getMessage() {
    return this.message;
  }

  public void setMessage(List<ScrappingDTO> message) {
    this.message = message;
  }
}
