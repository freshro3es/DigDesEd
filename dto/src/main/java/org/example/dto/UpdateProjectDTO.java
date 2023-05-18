package org.example.dto;

import org.example.libs.ProjStatus;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter @AllArgsConstructor
public class UpdateProjectDTO {

    private String name;
    private String description;
    private ProjStatus status;
    private int teamId;

}
