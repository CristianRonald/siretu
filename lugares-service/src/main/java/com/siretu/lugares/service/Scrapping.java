package com.siretu.lugares.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.siretu.shared_dto.dto.ScrappingDTO;

@Service
public class Scrapping {
  private List<ScrappingDTO> scrapping = new ArrayList<>();

  public List<ScrappingDTO> genFullSugerencias() {
    return scrapping;
  }

  public List<ScrappingDTO> getLugaresFromYtuQuePlanes() {
    try {
      this.getLugarTuristico("/destinos/huanuco");
      return scrapping;
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  private ScrappingDTO getLugarTuristico(String link) throws IOException {
    ScrappingDTO sdto = new ScrappingDTO();
    Document doc = Jsoup.connect("https://www.ytuqueplanes.com" + link).get();
    Element element = doc.select(".destinos").first();
    sdto.setTitle(doc.select(".title-seccion").text());
    sdto.setDescription(doc.select(".descripcion-destino").text());
    if (element == null || (!doc.select("#destinoNivel3").isEmpty() &&
        doc.select(".top-atractivos").isEmpty())) {
      return sdto;
    }
    Elements as = element.select("a");
    for (Element a : as) {
      if (!a.attribute("href").getValue().contains("destino"))
        continue;
      scrapping.add(getLugarTuristico(a.attribute("href").getValue()));
    }
    return sdto;
  }

  public void getPlatoTipico() {
  }
}
