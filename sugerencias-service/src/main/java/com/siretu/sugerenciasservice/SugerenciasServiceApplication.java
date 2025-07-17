package com.siretu.sugerenciasservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SugerenciasServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SugerenciasServiceApplication.class, args);
  }

}
