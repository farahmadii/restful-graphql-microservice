package com.farzan.webservices.repository;


import com.farzan.webservices.entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/*
what spring Data JPA is doing, underneath the covers it's taking care of all the hibernate commands all the
transactional commands, just about everything that otherwise one has to do manually because there is a lot ceremony code
for example in JDBC.
*/

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
}
