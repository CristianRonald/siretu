package com.siretu.user_service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siretu.user_service.dao.PersonRepository;
import com.siretu.user_service.dto.PersonDTO;
import com.siretu.user_service.model.Person;

@Service
public class PersonService {
  @Autowired
  PersonRepository personRepository;

  public Person createPerson(PersonDTO personRequest) {
    Person person = new Person();
    person.setIsForaneo(personRequest.getIsForaneo());
    person.setName(personRequest.getName());
    person.setEdad(personRequest.getEdad());
    return person;
  }

  public Person getOnePerson(UUID id) {
    try {
      Person person = personRepository.findById(id).orElse(null);
      return person;
    } catch (Exception e) {
      return null;
    }

  }

  public List<Person> getFullPerson() {
    try {
      List<Person> person = personRepository.findAll();
      return person;
    } catch (Exception e) {
      return null;
    }

  }
}
