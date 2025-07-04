package com.siretu.lugares.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EmbeddingConverter implements AttributeConverter<float[], String> {

  @Override
  public String convertToDatabaseColumn(float[] attribute) {
    if (attribute == null)
      return null;

    StringBuilder sb = new StringBuilder();
    sb.append('{');
    for (int i = 0; i < attribute.length; i++) {
      sb.append(attribute[i]);
      if (i < attribute.length - 1) {
        sb.append(',');
      }
    }
    sb.append('}');
    return sb.toString();
  }

  @Override
  public float[] convertToEntityAttribute(String dbData) {
    if (dbData == null || dbData.isEmpty())
      return new float[0];

    String clean = dbData.replace("{", "").replace("}", "");
    String[] parts = clean.split(",");
    float[] result = new float[parts.length];
    for (int i = 0; i < parts.length; i++) {
      result[i] = Float.parseFloat(parts[i].trim());
    }
    return result;
  }
}
