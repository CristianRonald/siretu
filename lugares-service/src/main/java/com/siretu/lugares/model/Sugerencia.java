package com.siretu.lugares.model;

public abstract class Sugerencia {

  public String descripcion;
  public String name;

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

}
