package com.siretu.nlpservice.dto;

import java.util.List;

import com.siretu.nlpservice.model.Entitie;

public class FullLugaresRespose {

  Entitie entitie;
  List<Double> embedding;

  public Entitie getEntitie() {
    return this.entitie;
  }

  public List<Double> getEmbedding() {
    return this.embedding;
  }

  public void setEmbedding(List<Double> embedding) {
    this.embedding = embedding;
  }

  public void setEntities(Entitie entitie) {
    this.entitie = entitie;
  }
}
