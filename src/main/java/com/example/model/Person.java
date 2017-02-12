package com.example.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by slava23 on 2/9/2017.
 */
@Data
@Document(collection = "person")
public class Person {
    @Id
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private List<Project> projects;
}
