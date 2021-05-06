package com.example.restservice.model;

import java.util.UUID;

public class Person {

    private UUID id;
    private Integer zipcode;
    private String name;
    private String lastname;
    private String city;
    private Integer cid;

    private String[] color = new String[8];

    public Person (UUID id,
                   String lastname,
                   String name,
                   Integer zipcode,
                   String city,
                   Integer cid){
        color[1] = "blau";
        color[2] = "grün";
        color[3] = "voilett";
        color[4] = "rot";
        color[5] = "gelb";
        color[6] = "türkis";
        color[7] = "weiß";

        this.id = id;
        this.cid = cid;
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.zipcode = zipcode;
        this.cid = cid;
    }

    public String getPcolor(){
        return getColor(cid);
    }

    public Integer getCid(){
        return cid;
    }

    public String getColor(Integer id){
        return color[id];
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public String getLastname(){
        return lastname;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
