package com.siretu.nlpservice.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.siretu.nlpservice.dto.NLPresponse;

@Service
public class IntentClassifier {

  public NLPresponse predictiIntent(String text) throws IOException, InterruptedException {
    String cText = text.replace("+", "");

    Path tempDir = Files.createTempDirectory("nlp_resources");

    InputStream pyScript = getClass().getClassLoader().getResourceAsStream("py/Classifier.py");
    Path tempScript = tempDir.resolve("Classifier.py");
    Files.copy(pyScript, tempScript, StandardCopyOption.REPLACE_EXISTING);

    InputStream modelFile = getClass().getClassLoader().getResourceAsStream("py/intent_classifier.pkl");
    Path tempModel = tempDir.resolve("intent_classifier.pkl");
    Files.copy(modelFile, tempModel, StandardCopyOption.REPLACE_EXISTING);

    ProcessBuilder pb = new ProcessBuilder("python", "Classifier.py");
    pb.directory(tempDir.toFile());
    pb.redirectErrorStream(true);

    Process process = pb.start();

    try (BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(process.getOutputStream()))) {
      writer.write(cText);
      writer.flush();
    }

    StringBuilder output = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(process.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line).append("\n");
      }
    }

    int exitCode = process.waitFor();
    if (exitCode != 0) {
      throw new RuntimeException(
          "Python script failed with code " + exitCode +
              "\nOutput: " + output.toString());
    }

    String[] parts = output.toString().trim().split(",");
    if (parts.length < 1) {
      throw new RuntimeException("Invalid Python output format");
    }

    NLPresponse nlpResponse = new NLPresponse();
    nlpResponse.setIntent(parts[0]);
    nlpResponse.setConfidence(parts.length > 1 ? Double.parseDouble(parts[1]) : 0);
    nlpResponse.setEntities(extractEntities(text));

    return nlpResponse;
  }

  public Map<String, String> extractEntities(String text) {
    try {
      ClassPathResource inputStream = new ClassPathResource("files/entities.csv");
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream.getInputStream()));
      String line;
      Map<String, String> entities = new HashMap<>();
      while ((line = reader.readLine()) != null) {
        String[] split = line.split(",");
        if (text.contains(split[0].toLowerCase())) {
          entities.put(split[1].trim(), split[0].trim());
          entities.put("tipo", split[2].trim());
        }
      }
      return entities;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

}
