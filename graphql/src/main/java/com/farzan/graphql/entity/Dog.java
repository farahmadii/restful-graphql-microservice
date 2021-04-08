package com.farzan.graphql.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String breed;
    String name;
    String origin;

    public Dog(Long id, String breed, String name, String origin) {
        this.id = id;
        this.breed = breed;
        this.name = name;
        this.origin = origin;
    }

    public Dog(){

    }

    public Dog(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
