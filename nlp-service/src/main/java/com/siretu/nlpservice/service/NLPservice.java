package com.siretu.nlpservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siretu.nlpservice.dto.NLPrequest;

@Service
public class NLPservice {

  @Autowired
  Embedding embedding;

  @Autowired
  IntentClassifier intentClassifier;

  public List<Double> getResponse(NLPrequest nr) {
    try {
      return embedding.generateEmbedding(nr);
    } catch (Exception e) {
      return null;
    }
  }
}
