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
  public List<LugarTuristico> buscarSimilares(float[] embedding, int limite) {
    List<LugarTuristico> resultados = new ArrayList<>();
    System.out.println(embedding);
    try (Connection conn = datasource.getConnection()) {
      PreparedStatement stmt = conn.prepareStatement(
          "SELECT title, localidad, tipo, descripcion FROM lugar_turistico ORDER BY embedding <-> ? LIMIT ?");
      stmt.setObject(1, new PGvector(embedding));
      stmt.setInt(2, limite);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        LugarTuristico lt = new LugarTuristico();
        lt.setTitle(rs.getString("title"));
        lt.setTipo(rs.getString("tipo"));
        lt.setDescripcion(rs.getString("descripcion"));
        lt.setLocalidad(rs.getString("localidad"));
        resultados.add(lt);
      }
    } catch (SQLException e) {
      throw new RuntimeException("Error al buscar lugares similares", e);
    }
    return resultados;
  }
}
