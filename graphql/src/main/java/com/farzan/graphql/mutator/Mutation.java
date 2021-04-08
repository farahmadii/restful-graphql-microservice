package com.farzan.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.farzan.graphql.entity.Dog;
import com.farzan.graphql.exception.BreedNotFoundException;
import com.farzan.graphql.exception.DogNotFoundException;
import com.farzan.graphql.repository.DogRepository;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Boolean deleteDogBreed(String breed){
        boolean deleted= false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        for(Dog d: allDogs){
            if(d.getBreed().equals(breed)){
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if(!deleted){
            throw new BreedNotFoundException("Breed Not Found!", breed);
        }
        return deleted;
    }

    public Dog updateDogName(String newName, Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        }
        else{
            throw new DogNotFoundException("Dog Not Found!", id);
        }
    }
}
