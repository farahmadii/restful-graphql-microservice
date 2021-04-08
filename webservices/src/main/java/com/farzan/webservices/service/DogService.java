package com.farzan.webservices.service;


import com.farzan.webservices.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> retrieveDogs();
    List<String> retrieveDogBreeds();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
}
