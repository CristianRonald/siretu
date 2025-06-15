<<<<<<< HEAD
package com.siretu.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> rescate-nlp
import org.springframework.web.bind.annotation.RestController;

import com.siretu.chatbot.service.MessageService;

import lombok.RequiredArgsConstructor;

import com.siretu.chatbot.client.SugerenciasClient;
import com.siretu.chatbot.dto.MessageDto;

<<<<<<< HEAD
@RestController("mensaje")
=======
@RestController
@RequestMapping("/ask")
>>>>>>> rescate-nlp
@RequiredArgsConstructor
public class MessageController {
  @Autowired
  private MessageService messageService;

  // private final SugerenciasClient sugerenciasClient;

  @PostMapping
  public void recieveMessage(@RequestBody MessageDto message) {
    messageService.recieveMessage(message);
  }
}
=======
package com.siretu.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.siretu.chatbot.service.MessageService;

import lombok.RequiredArgsConstructor;

import com.siretu.chatbot.client.SugerenciasClient;
import com.siretu.chatbot.dto.MessageDto;

@RestController("mensaje")
@RequiredArgsConstructor
public class MessageController {
  @Autowired
  private MessageService messageService;

  // private final SugerenciasClient sugerenciasClient;

  @PostMapping
  public void recieveMessage(@RequestBody MessageDto message) {
    messageService.recieveMessage(message);
  }
}
>>>>>>> 846f88161ea4aaf513941fd9b73c382eacd7b663
