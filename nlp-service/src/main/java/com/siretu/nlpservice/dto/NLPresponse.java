package com.siretu.nlpservice.dto;

import java.util.List;
import java.util.Map;

/**
 * NLPresponse
 */
public class NLPresponse {

  private String intent;
  private double confidence;
  private List<Map<String, String>> entities;

  public String getIntent() {
    return this.intent;
  }

  public double getConfidence() {
    return this.confidence;
  }

  public List<Map<String, String>> getEntities() {
    return this.entities;
  }

  public void setIntent(String intent) {
    this.intent = intent;
  }

  public void setConfidence(double confidence) {
    this.confidence = confidence;
  }

  public void setEntities(List<Map<String, String>> entities) {
    this.entities = entities;
  }
}
