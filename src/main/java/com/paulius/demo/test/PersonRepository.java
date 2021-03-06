package com.paulius.demo.test;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// persist/access Person objects stored in Apache Geode.

@RepositoryRestResource(collectionResourceRel = "people",path = "people")
public interface PersonRepository extends CrudRepository<Person,Long> {

    List<Person> findByLastName(@Param("name") String name);
}
