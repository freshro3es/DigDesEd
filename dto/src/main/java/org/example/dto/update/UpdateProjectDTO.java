package org.example.dto.update;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import lombok.Getter;


@Getter @Setter @NoArgsConstructor @ToString
public class UpdateProjectDTO {

    private String code;
    private String name;
    private String description;
    private Long teamId;

}
