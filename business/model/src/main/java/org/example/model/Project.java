package org.example.model;

import org.example.libs.ProjStatus;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter @Setter @ToString @AllArgsConstructor
public class Project implements Serializable {

    private final int id;
    private String name;
    private String description;
    private ProjStatus status;
    private Team team;

}
