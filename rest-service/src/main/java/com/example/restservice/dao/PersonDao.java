package com.example.restservice.dao;

import com.example.restservice.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(Integer id, String lastname, String name, Integer zipcode, String city);

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);

    List<Person> getPersonsById(UUID id);

    List<Person> getPersonsByColor(String color);
}
