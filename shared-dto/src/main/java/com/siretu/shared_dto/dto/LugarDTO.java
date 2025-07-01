package com.siretu.shared_dto.dto;

import java.util.List;

public class LugarDTO {

  EntitieDTO entitie;
  List<Double> embedding;

  public EntitieDTO getEntitie() {
    return this.entitie;
  }

  public List<Double> getEmbedding() {
    return this.embedding;
  }

  public void setEmbedding(List<Double> embedding) {
    this.embedding = embedding;
  }

  public void setEntities(EntitieDTO entitie) {
    this.entitie = entitie;
  }
}
