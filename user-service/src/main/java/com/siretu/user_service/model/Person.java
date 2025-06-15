package com.siretu.user_service.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Person {

  @Id
  @GeneratedValue
  private UUID id;
  private String name;
  private int edad;
  private boolean isForaneo;
  private String pass;

  public UUID getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public int getEdad() {
    return this.edad;
  }

  public boolean getIsForaneo() {
    return this.isForaneo;
  }

  public String getPassword() {
    return this.pass;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public void setIsForaneo(boolean isForaneo) {
    this.isForaneo = isForaneo;
  }
}
