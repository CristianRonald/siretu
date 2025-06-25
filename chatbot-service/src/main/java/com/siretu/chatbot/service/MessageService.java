package com.siretu.chatbot.service;

import org.springframework.stereotype.Service;

import com.siretu.chatbot.dto.MessageDto;

@Service
public class MessageService {

  public String cleanMessage(String message) {
    return message.strip();
  }

  public String recieveMessage(MessageDto message) {

    return message.getMessage();
  }
}
