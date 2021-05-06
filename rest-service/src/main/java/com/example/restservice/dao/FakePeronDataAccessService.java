package com.example.restservice.dao;

import com.example.restservice.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("fakeDao")
public class FakePeronDataAccessService implements PersonDao{

    public List<Person> DB = new ArrayList<Person>();


    @Override
    public int insertPerson(Integer id, String lastname, String name, Integer zipcode, String city) {
        DB.add(new Person(UUID.randomUUID(), lastname, name, zipcode, city, id));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public List<Person> getPersonsById(UUID id){
        //return DB.stream().forEach(p -> p.getId().equals(id));
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMayBe = selectPersonById(id);
        if(personMayBe.isEmpty()){
            return 0;
        }
        DB.remove(personMayBe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = DB.indexOf(p);
                    if(indexOfPersonToUpdate >= 0){
                        if(update.getName() == null)
                            update.setName(p.getName());
                        if(update.getLastname() == null)
                            update.setLastname(p.getLastname());
                        if(update.getZipcode() == null)
                            update.setZipcode(p.getZipcode());
                        if(update.getCity() == null)
                            update.setCity(p.getCity());
                        DB.set(indexOfPersonToUpdate, new Person(id, update.getLastname(), update.getName(), update.getZipcode(),update.getCity(), update.getCid()));
                        return  1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public List<Person> getPersonsByColor(String reqcolor){
        return DB.stream()
                .filter(person -> person.getPcolor().equals(reqcolor))
                .collect(Collectors.toList());
    }
}
