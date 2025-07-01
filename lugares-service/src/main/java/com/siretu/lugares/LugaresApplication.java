package com.siretu.lugares;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LugaresApplication {

  public static void main(String[] args) {
    SpringApplication.run(LugaresApplication.class, args);
  }

}
