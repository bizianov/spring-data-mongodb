package com.example.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by slava23 on 2/9/2017.
 */
@Data
public class Project {
    @Id
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private List<Technology> technologies;
}
