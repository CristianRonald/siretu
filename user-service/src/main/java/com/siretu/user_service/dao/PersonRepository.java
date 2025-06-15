package com.siretu.user_service.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siretu.user_service.model.Person;

/**
 * PersonRepository
 */
public interface PersonRepository extends JpaRepository<Person, UUID> {

}
