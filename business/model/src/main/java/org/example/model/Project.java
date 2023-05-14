package org.example.model;

public class Project {

    private String id;
    private String name;
    private String description;
    private ProjStat status;

    public Project(String id, String name, String description, ProjStat status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }
}
