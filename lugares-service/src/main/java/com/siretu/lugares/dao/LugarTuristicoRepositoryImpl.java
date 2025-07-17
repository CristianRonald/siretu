package com.siretu.lugares.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.pgvector.PGvector;
import com.siretu.lugares.model.LugarTuristico;
import com.siretu.shared_dto.dto.LugarTuristicoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LugarTuristicoRepositoryImpl implements LugarTuristicoRepositoryCustom {

  @Autowired
  DataSource datasource;

  @Override
  public void insertarLugar(LugarTuristico lugarTuristico, int id) {
    try (Connection conn = datasource.getConnection()) {
      PreparedStatement stmt = conn.prepareStatement(
          "INSERT INTO lugar_turistico (id,title,localidad,tipo,descripcion, embedding) VALUES (?, ?, ?,?,?,?)");
      stmt.setInt(1, id);
      stmt.setString(2, lugarTuristico.getTitle());
      stmt.setString(3, lugarTuristico.getLocalidad());
      stmt.setString(4, lugarTuristico.getTipo());
      stmt.setString(5, lugarTuristico.getDescripcion());
      stmt.setObject(6, new PGvector(lugarTuristico.getEmbedding()));
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Error al crear el lugar turistico.");
    }
  }

  @Override
  public List<LugarTuristicoDTO> buscarSimilares(float[] embedding, int limite) {
    List<LugarTuristicoDTO> resultados = new ArrayList<>();
    PGvector vector = new PGvector(embedding);
    try (Connection conn = datasource.getConnection()) {
      PreparedStatement stmt = conn.prepareStatement(
          "SELECT title, localidad, tipo, descripcion, embedding <=> ? AS distancia " +
              "FROM lugar_turistico " +
              "WHERE embedding <=> ? < ? " +
              "ORDER BY distancia " +
              "LIMIT ?");
      stmt.setObject(1, vector);
      stmt.setObject(2, vector);
      stmt.setObject(3, 0.8);
      stmt.setInt(4, limite);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        LugarTuristicoDTO lt = new LugarTuristicoDTO();
        lt.setTitle(rs.getString("title"));
        lt.setTipo(rs.getString("tipo"));
        lt.setDescripcion(rs.getString("descripcion"));
        lt.setLocalidad(rs.getString("localidad"));
        lt.setDistancia(rs.getFloat("distancia"));
        resultados.add(lt);
      }
    } catch (SQLException e) {
      throw new RuntimeException("Error al buscar lugares similares", e);
    }
    return resultados;
  }
}
