package org.example.dto.order;


import lombok.AllArgsConstructor;
import lombok.Setter;
import org.example.libs.ProjStatus;

import lombok.Getter;

@Getter @Setter @AllArgsConstructor
public class OrderProjectDTO {

    private String name;
    private String description;
    private ProjStatus status;
    private String team;

}
