package org.example.dto;

import org.example.libs.ProjStatus;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter @AllArgsConstructor
public class OrderProjectDTO {

    private String name;
    private String description;
    private ProjStatus status;
    private String team;

}
