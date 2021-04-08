package com.farzan.webservices.service;

import com.farzan.webservices.entity.Dog;
import com.farzan.webservices.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService{
    private DogRepository dogRepository;

    @Autowired
    public void setDogRepository(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public List<Dog> retrieveDogs(){
        return (List<Dog>) dogRepository.findAll();
    }
    public List<String> retrieveDogBreeds() {
        return (List<String>) dogRepository.findAllBreeds();
    }
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundExceptionHandler::new);
        return breed;
    }
    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllNames();
    }

}
