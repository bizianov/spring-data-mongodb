package com.example.repo;

import com.example.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by slava23 on 2/9/2017.
 */
public interface PersonRepository extends MongoRepository<Person, Integer> {
    List<Person> findByName(String name);
    List<Person> findByProjectsName(String projectName);
    List<Person> findByProjectsNameEndingWith(String projectNameSuffix);
    List<Person> findByProjectsTechnologiesName(String technologyName);
    @Query("{'name':{$regex:?0}}")
    List<Person> findByNameLike(String nameLike);
    @Query("{'projects.technologies.name':{$regex:?0}}")
    List<Person> findByProjectsTechnologiesNameLike(String technologyNameSuffix);
}
