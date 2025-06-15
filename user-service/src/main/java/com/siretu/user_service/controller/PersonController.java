package com.siretu.user_service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siretu.user_service.model.Person;
import com.siretu.user_service.dto.PersonDTO;
import com.siretu.user_service.services.PersonService;

@RestController
@RequestMapping("api/person")
public class PersonController {
  @Autowired
  PersonService personService;

  @PostMapping
  public ResponseEntity<Person> createPerson(@RequestBody PersonDTO personRequest) {
    return ResponseEntity.ok(personService.createPerson(personRequest));
  }

  @GetMapping(path = "{id}")
  public ResponseEntity<Person> getOnePerson(@PathVariable("id") UUID id) {
    return ResponseEntity.ok(personService.getOnePerson(id));
  }

  @GetMapping
  public ResponseEntity<List<Person>> getFullPerson() {
    return ResponseEntity.ok(personService.getFullPerson());
  }

  @PutMapping
  public void updatePerson() {
  }

  @DeleteMapping
  public void deletePerson() {
  }
}
