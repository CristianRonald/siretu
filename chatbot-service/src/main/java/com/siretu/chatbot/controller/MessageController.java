package com.siretu.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siretu.chatbot.service.MessageService;

import com.siretu.chatbot.dto.MessageDto;

@RestController
@RequestMapping("/api/v2/ask")
public class MessageController {
  @Autowired
  MessageService messageService;

  @PostMapping
  public String recieveMessage(@RequestBody MessageDto message) {
    return messageService.recieveMessage(message);
  }
}
