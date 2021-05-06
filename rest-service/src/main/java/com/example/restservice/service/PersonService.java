package com.example.restservice.service;

import com.example.restservice.dao.PersonDao;
import com.example.restservice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;

        addPerson(1,"Zierke", "Sascha", 12309, "Berlin");
        addPerson(1,"Müller", "Hans", 67742, "Lauterecken");
        addPerson(2,"Petersen", "Peter", 18439, "Stralsund");
        addPerson(3,"Johnson", "Johnny", 88888, "made up");
        addPerson(2,"Andersson", "Anders", 32132, "Schweden ");
        addPerson(6,"Fujitsu", "Tastatur", 42342, "Japan");
    }

    public int addPerson(Integer id, String lastname, String name, Integer zipcode, String city){
        return personDao.insertPerson(id, lastname, name, zipcode,city);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }

    public List<Person> getPersonsById(UUID id){
        return personDao.getPersonsById(id);
    }

    public List<Person> getPersonsByColor(String color) {return personDao.getPersonsByColor(color);}
}
