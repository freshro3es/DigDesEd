package org.example.dto;

import org.example.libs.ProjStat;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter @AllArgsConstructor
public class UpdateProjectDTO {

    private String name;
    private String description;
    private ProjStat status;
    private int team_id;

}
