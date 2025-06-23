package com.siretu.nlpservice.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siretu.nlpservice.dto.NLPrequest;

@Service
/**
 * Embedding
 */
public class Embedding {

  public List<Double> generateEmbedding(NLPrequest nlPrequest) throws IOException {

    String texto = nlPrequest.getMessage();
    Path tempDir = Files.createTempDirectory("nlp_resources");

    InputStream pyScript = getClass().getClassLoader().getResourceAsStream("py/embedding.py");
    Path tempScript = tempDir.resolve("embedding.py");
    Files.copy(pyScript, tempScript, StandardCopyOption.REPLACE_EXISTING);

    ProcessBuilder pb = new ProcessBuilder("py", "embedding.py");
    Process proceso = pb.start();
    OutputStream stdin = proceso.getOutputStream();
    stdin.write(texto.getBytes(StandardCharsets.UTF_8));
    stdin.close();

    BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
    String json = reader.lines().collect(Collectors.joining());
    List<Double> vector = new ObjectMapper().readValue(json, new TypeReference<>() {
    });
    return vector;
  }
}
