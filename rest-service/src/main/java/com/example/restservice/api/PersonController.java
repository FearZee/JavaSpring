package com.example.restservice.api;

import com.example.restservice.model.Person;
import com.example.restservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Integer id, String lastname, String name, Integer zipcode, String city){
        personService.addPerson(id, lastname,name,zipcode,city);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

   @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id,@RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }

    @GetMapping(path = "all/{id}")
    public List<Person> getPersonsById(@PathVariable("id")UUID id){
        return personService.getPersonsById(id);
    }

    @GetMapping(path = "color/{color}")
    public List<Person> getPersonsByColor(@PathVariable("color")String color){ return personService.getPersonsByColor(color);}
}