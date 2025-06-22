package com.siretu.sugerenciasservice.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public abstract class Sugerencia {

  @Id
  @GeneratedValue
  public UUID id;

  public String descripcion;
  public String name;
  // Embedding
  @Column(columnDefinition = "vector(384)")
  private float[] embedding;

  public String getDescripcion() {
    return this.descripcion;
  }

  public String getName() {
    return this.name;
  }

  public void setDescripcion(String name) {
    this.name = name;
  }

  public void setName(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setEmbedding(float[] embedding) {
    this.embedding = embedding;
  }
}
