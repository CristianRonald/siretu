package com.siretu.sugerenciasservice.model;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Establecimiento
 */
@Entity
public abstract class Establecimiento {

  @Id
  @GeneratedValue
  private UUID id;
  private Map<Double, Double> ubicacion;
  private Map<Date, Date> horario;

  public Map<Double, Double> getUbicacion() {
    return this.ubicacion;
  }

  public Map<Date, Date> getHorario() {
    return this.horario;
  }

  public void setUbicacion(Map<Double, Double> ubicacion) {
    this.ubicacion = ubicacion;
  }

  public void setHorario(Map<Date, Date> horario) {
    this.horario = horario;
  }
}
