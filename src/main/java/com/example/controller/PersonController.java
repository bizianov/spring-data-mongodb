package com.example.controller;

import com.example.service.PersonService;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by slava23 on 2/11/2017.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping("/count")
    public String count() {
        long count = service.count();
        return "There are " + count + " persons in db";
    }

    @RequestMapping("/findByProject/{name}")
    public List<Person> findByProject(@PathVariable(value = "name") String name) {
        return service.findByProjectName(name);
    }

    @RequestMapping("/findByName/{personName}")
    public List<Person> findByName(@PathVariable(value = "personName") String personName) {
        return service.findByName(personName);
    }
}
