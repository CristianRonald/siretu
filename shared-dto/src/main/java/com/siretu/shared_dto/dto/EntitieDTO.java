package com.siretu.shared_dto.dto;

public class EntitieDTO {

  private ScrappingDTO scrapingDTO;
  private String localidad;
  private String tipo;
  private String actividades;

  public String getLocalidad() {
    return localidad;
  }

  public ScrappingDTO getScrappingDTO() {
    return this.scrapingDTO;
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

  public void setScrapingDTO(ScrappingDTO scrapingDTO) {
    this.scrapingDTO = scrapingDTO;
  }

}
