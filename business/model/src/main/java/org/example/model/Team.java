package org.example.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter @Setter @ToString @AllArgsConstructor
public class Team implements Serializable {

    private final int id;
    private String name;
    private List<Employee> employees;

}
