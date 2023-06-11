package org.example.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import lombok.Getter;


@Getter @Setter @NoArgsConstructor @ToString
@Schema(description = "Class representing an update project request")
public class UpdateProjectDTO {

    @Schema(description = "The unique code of the project", example = "AA-00-AA")
    private String code;

    @Schema(description = "The name of the project", example = "My awesome project")
    private String name;

    @Schema(description = "A brief summary of the project's purpose and goals", example = "This project aims to develop a cutting-edge web application.")
    private String description;

    @Schema(description = "The ID of the team responsible for this project", example = "2")
    private Long teamId;

}
