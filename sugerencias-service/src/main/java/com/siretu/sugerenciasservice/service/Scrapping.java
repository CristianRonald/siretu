package com.siretu.sugerenciasservice.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.siretu.sugerenciasservice.model.LugarTuristico;
import com.siretu.sugerenciasservice.model.Sugerencia;

@Service
public class Scrapping {
  private List<Sugerencia> sugerencias = new ArrayList<>();

  public List<Sugerencia> genFullSugerencias() {
    return sugerencias;
  }

  public Sugerencia getLugarTuristico(String link) throws IOException {
    Sugerencia sg = new LugarTuristico();
    Document doc = Jsoup.connect("https://www.ytuqueplanes.com" + link).get();
    Element element = doc.select(".destinos").first();
    sg.setName(doc.select(".title-seccion").text());
    sg.setDescripcion(doc.select(".descripcion-destino").text());
    if (element == null || (!doc.select("#destinoNivel3").isEmpty() &&
        doc.select(".top-atractivos").isEmpty())) {
      return sg;
    }
    Elements as = element.select("a");
    for (Element a : as) {
      if (!a.attribute("href").getValue().contains("destino"))
        continue;
      sugerencias.add(getLugarTuristico(a.attribute("href").getValue()));
    }
    return sg;
  }

  public void getPlatoTipico() {
  }
}
