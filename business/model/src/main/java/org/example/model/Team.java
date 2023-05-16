package org.example.model;

import java.io.Serializable;
import java.util.List;

public class Team extends Model implements Serializable {
    private final int id;
    private String name;
    private List<Employee> employees;

    public Team(int id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
