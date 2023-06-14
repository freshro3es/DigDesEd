package org.example.dto.order;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.ProjStatus;

import lombok.Getter;

@Getter @Setter @AllArgsConstructor @ToString
@Schema(description = "Class representing a project object representation response")
public class OrderProjectDTO {

    @Schema(description = "ID of the project", example = "1")
    private Long id;

    @Schema(description = "Code for the project", example = "AA-00-AA")
    private String code;

    @Schema(description = "Name of the project", example = "New Website Design")
    private String name;

    @Schema(description = "Description of the project", example = "A project to redesign the company's website.")
    private String description;

    @Schema(description = "Status of the project", example = "IN_PROGRESS")
    private ProjStatus status;

    @Schema(description = "Team working on the project", example = "Web Development Team")
    private String team;

}
