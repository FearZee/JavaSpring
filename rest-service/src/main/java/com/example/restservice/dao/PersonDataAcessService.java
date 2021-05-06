package com.example.restservice.dao;

import com.example.restservice.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAcessService implements PersonDao{

    @Override
    public int insertPerson(Integer id, String lastname, String name, Integer zipcode, String city) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return List.of((new Person(UUID.randomUUID(), "Zierke","Sascha", 12309, "Berlin", 1)));
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getPersonsById(UUID id) {
        return null;
    }

    @Override
    public List<Person> getPersonsByColor(String color) {
        return null;
    }
}
