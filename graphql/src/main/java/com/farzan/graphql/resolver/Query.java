package com.farzan.graphql.resolver;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.farzan.graphql.entity.Dog;
import com.farzan.graphql.exception.DogNotFoundException;
import com.farzan.graphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            return dog;
        }else{
            throw new DogNotFoundException("Dog not found", id);
        }
    }
}
