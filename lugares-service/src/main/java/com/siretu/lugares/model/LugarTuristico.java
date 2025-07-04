package com.siretu.lugares.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.List;

@Entity
public class LugarTuristico {

  @Id
  private Long id;
  private String title;
  private String localidad;
  private String tipo;
  @Lob
  @Column(name = "descripcion", columnDefinition = "TEXT")
  private String descripcion;

  private List<String> ubicacion;

  @Column(name = "embedding", columnDefinition = "vector(384)")
  private float[] embedding;

  public String getLocalidad() {
    return localidad;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setLocalidad(String localidad) {
    this.localidad = localidad;
  }

  public String getTipo() {
    return tipo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public List<String> getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(List<String> ubicacion) {
    this.ubicacion = ubicacion;
  }

  public float[] getEmbedding() {
    return embedding;
  }

  public void setEmbedding(float[] embedding) {
    this.embedding = embedding;
  }
}
