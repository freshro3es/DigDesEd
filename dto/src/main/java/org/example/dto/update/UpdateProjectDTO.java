package org.example.dto.update;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.libs.ProjStatus;

import lombok.Getter;


@Getter @Setter @NoArgsConstructor
public class UpdateProjectDTO {

    private String name;
    private String description;
    private ProjStatus status;
    private Long teamId;

}
