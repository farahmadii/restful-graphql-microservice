package com.farzan.webservices.repository;


import com.farzan.webservices.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/*
what spring Data JPA is doing, underneath the covers it's taking care of all the hibernate commands all the
transactional commands, just about everything that otherwise one has to do manually because there is a lot ceremony code
for example in JDBC.
*/

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findBreedById(Long id);

    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreeds();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllNames();

}
