package com.siretu.shared_dto.dto;

import java.util.List;

public class LugarTuristicoDTO {

  private String title;
  private String localidad;
  private String tipo;
  private String actividad;
  private String descripcion;
  private float distancia;

  private List<String> ubicacion;

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

  public String getActividad() {
    return this.actividad;
  }

  public void setActividad(String actividad) {
    this.actividad = actividad;
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

  public float getDistancia() {
    return distancia;
  }

  public void setDistancia(float distancia) {
    this.distancia = distancia;
  }
}
