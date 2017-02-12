package com.example.service;

import com.example.repo.PersonRepository;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by slava23 on 2/11/2017.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public long count() {
        return repository.count();
    }

    public List<Person> findByProjectName(String projectName) {
        return repository.findByProjectsName(projectName);
    }

    public List<Person> findByName(String personName) {
        return repository.findByName(personName);
    }
}
