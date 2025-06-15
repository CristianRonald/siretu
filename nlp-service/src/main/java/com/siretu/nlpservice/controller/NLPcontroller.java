package com.siretu.nlpservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siretu.nlpservice.dto.NLPresponse;
import com.siretu.nlpservice.service.IntentClassifier;

@RestController
@RequestMapping("api/nlp")
public class NLPcontroller {

  @Autowired
  IntentClassifier IntentClassifier;

  @GetMapping
  public String verificar() {
    return "hola";
  }

  @GetMapping(path = "{text}")
  public ResponseEntity<?> predictIntent(@PathVariable String text) {
    try {
      NLPresponse response = IntentClassifier.predictiIntent(text);
      return ResponseEntity.ok(response);
    } catch (IOException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error processing request: " + e.getMessage());
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
          .body("Request interrupted");
    }
  }
}
