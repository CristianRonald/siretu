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
import com.siretu.shared_dto.dto.MessageDTO;

@Service
/**
 * Embedding
 */
public class Embedding {

  public List<Double> generateEmbedding(MessageDTO messageDTO) throws IOException, InterruptedException {

    String texto = messageDTO.getMessage();

    InputStream pyScript = getClass().getClassLoader().getResourceAsStream("py/embedding.py");
    Path tempScript = Files.createTempFile("embedding", ".py");
    Files.copy(pyScript, tempScript, StandardCopyOption.REPLACE_EXISTING);

    ProcessBuilder pb = new ProcessBuilder("python3", tempScript.toAbsolutePath().toString());
    Process proceso = pb.start();

    try (OutputStream stdin = proceso.getOutputStream()) {
      stdin.write(texto.getBytes(StandardCharsets.UTF_8));
      stdin.flush();
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
    String json = reader.lines().collect(Collectors.joining());

    BufferedReader errorReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
    String errors = errorReader.lines().collect(Collectors.joining("\n"));
    if (!errors.isEmpty()) {
      System.err.println("Python error: " + errors);
    }

    int exitCode = proceso.waitFor();
    if (exitCode != 0) {
      throw new RuntimeException("Python script failed with exit code " + exitCode);
    }

    List<Double> vector = new ObjectMapper().readValue(json, new TypeReference<>() {
    });
    return vector;
  }
}
