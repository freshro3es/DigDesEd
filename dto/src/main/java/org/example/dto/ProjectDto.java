package org.example.dto;

import org.example.libs.ProjStat;

public class ProjectDto {
    private final int id;
    private String name;
    private String description;
    private ProjStat status;
    private TeamDto team;

    public ProjectDto(int id, String name, String description, ProjStat status) {
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

    public TeamDto getTeam() {
        return team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
    }
}
