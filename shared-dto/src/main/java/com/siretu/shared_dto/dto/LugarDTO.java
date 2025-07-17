package com.siretu.shared_dto.dto;

import java.util.List;

public class LugarDTO {

  EntitieDTO entitie;
  float[] embedding;

  public EntitieDTO getEntitie() {
    return this.entitie;
  }

  public float[] getEmbedding() { 
    return this.embedding;
  }

  public void setEmbedding(float[] embedding) {
    this.embedding = embedding;
  }

  public void setEntities(EntitieDTO entitie) {
    this.entitie = entitie;
  }
}
