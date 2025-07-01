package com.siretu.lugares.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import java.util.List;
import java.util.UUID;

@Entity
public class LugarTuristico {

  @Id
  @GeneratedValue
  private UUID id;

  private String title;
  private String localidad;
  private String tipo;
  private String descripcion;

  @ElementCollection
  @CollectionTable(name = "ubicaciones", joinColumns = @JoinColumn(name = "lugar_id"))
  @Column(name = "valor")
  private List<String> ubicacion;

  @ElementCollection
  @CollectionTable(name = "embedding_vector", joinColumns = @JoinColumn(name = "lugar_id"))
  @Column(name = "value")
  private List<Double> embedding;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

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

  public List<Double> getEmbedding() {
    return embedding;
  }

  public void setEmbedding(List<Double> embedding) {
    this.embedding = embedding;
  }
}
