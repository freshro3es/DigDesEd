package org.example.model;

import org.example.libs.ProjStat;

import java.io.Serializable;

public class Project extends Model implements Serializable {

    private final int id;
    private String name;
    private String description;
    private ProjStat status;
    private Team team;

    //в конструкторе тоже нет команды

    public Project(int id, String name, String description, ProjStat status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjStat getStatus() {
        return status;
    }

    public void setStatus(ProjStat status) {
        this.status = status;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
