package com.siretu.nlpservice.dto;

import java.util.Map;

/**
 * NLPresponse
 */
public class NLPresponse {

  private String intent;
  private double confidence;
  private float[] embedding;
  private Map<String, String> entities;

  public String getIntent() {
    return this.intent;
  }

  public float[] getEmbedding() {
    return this.embedding;
  }

  public double getConfidence() {
    return this.confidence;
  }

  public Map<String, String> getEntities() {
    return this.entities;
  }

  public void setIntent(String intent) {
    this.intent = intent;
  }

  public void setEmbedding(float[] embedding) {
    this.embedding = embedding;
  }

  public void setConfidence(double confidence) {
    this.confidence = confidence;
  }

  public void setEntities(Map<String, String> entities) {
    this.entities = entities;
  }
}
