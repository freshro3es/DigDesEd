package org.example.dto.order;


import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.ProjStatus;

import lombok.Getter;

@Getter @Setter @AllArgsConstructor @ToString
public class OrderProjectDTO {

    private Long id;
    private String code;
    private String name;
    private String description;
    private ProjStatus status;
    private String team;

}
