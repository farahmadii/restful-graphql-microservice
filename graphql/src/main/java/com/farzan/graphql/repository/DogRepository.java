package com.farzan.graphql.repository;

import com.farzan.graphql.entity.Dog;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;


@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
}
