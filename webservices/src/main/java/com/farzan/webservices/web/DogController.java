package com.farzan.webservices.web;


import com.farzan.webservices.entity.Dog;
import com.farzan.webservices.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


// providing custom error messages for swagger
@ApiResponses(value = {
        @ApiResponse(responseCode="400", description = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(responseCode="401", description = "Due to security constraints, your access request cannot be authorized. "),
        @ApiResponse(responseCode="500", description = "The server is down. Please make sure that the Location microservice is running.")})
        @Tag(name ="dog", description = "dog breeds api")



@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> findAllDogs(){
        List<Dog> dogs = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(dogs,HttpStatus.OK);
    }

    @GetMapping("dogs/breed")
    public ResponseEntity<List<String>> findAllBreeds(){
        List<String> breeds = dogService.retrieveDogBreeds();
        return new ResponseEntity<List<String>>(breeds, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> findAllNames(){
        List<String> names = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> findBreedById(@PathVariable Long id){
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }
}
