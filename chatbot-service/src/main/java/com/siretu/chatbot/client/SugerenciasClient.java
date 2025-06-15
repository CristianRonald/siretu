<<<<<<< HEAD
package com.siretu.chatbot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.siretu.chatbot.dto.MessageDto;

@FeignClient(name = "service-sugerencias")
public interface SugerenciasClient {
  @PostMapping("/sugerencias/client")
  void procesarMensaje(@RequestBody MessageDto mensaje);
}
=======
package com.siretu.chatbot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.siretu.chatbot.dto.MessageDto;

@FeignClient(name = "service-sugerencias")
public interface SugerenciasClient {
  @PostMapping("/sugerencias/client")
  void procesarMensaje(@RequestBody MessageDto mensaje);
}
>>>>>>> 846f88161ea4aaf513941fd9b73c382eacd7b663
