package com.siretu.nlpservice.model;

public class Entitie {

  private String localidad;
  private String tipo;
  private String actividades;

  public String getLocalidad() {
    return localidad;
  }

  public String getActividades() {
    return this.actividades;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setLocated(String localidad) {
    this.localidad = localidad;
  }

  public void setActividades(String actividades) {
    this.actividades = actividades;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
