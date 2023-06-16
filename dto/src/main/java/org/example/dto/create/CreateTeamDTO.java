package org.example.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter @Setter @NoArgsConstructor @ToString
@Schema(description = "Class representing a create team request")
public class CreateTeamDTO {

    @NotBlank(message = "Name cannot be null")
    @Size(min = 2, max = 50, message = "name length must be between 2 and 50 characters")
    @Schema(description = "Team name", example = "New Team")
    private String name;

}
