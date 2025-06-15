<<<<<<< HEAD
<<<<<<< HEAD
package com.siretu.chatbot.Service;
=======
package com.siretu.chatbot.service;
>>>>>>> rescate-nlp

import org.springframework.stereotype.Service;

import com.siretu.chatbot.dto.MessageDto;

@Service
public class MessageService {

  public String cleanMessage(String message) {
    return message.strip();
  }

  public void recieveMessage(MessageDto message) {
<<<<<<< HEAD
=======

>>>>>>> rescate-nlp
  }
}
=======
package com.siretu.chatbot.Service;

import org.springframework.stereotype.Service;

import com.siretu.chatbot.dto.MessageDto;

@Service
public class MessageService {

  public String cleanMessage(String message) {
    return message.strip();
  }

  public void recieveMessage(MessageDto message) {
  }
}
>>>>>>> 846f88161ea4aaf513941fd9b73c382eacd7b663
