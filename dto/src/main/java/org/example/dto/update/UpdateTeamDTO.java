package org.example.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Schema(description = "Class representing an update team request")
public class UpdateTeamDTO {

    @Schema(description = "The updated name of the team", example = "Development Team")
    private String name;

}
