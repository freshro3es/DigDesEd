package org.example.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.TeamRole;

@Getter @Setter @NoArgsConstructor @ToString
@Schema(description = "Class representing an add employee to the team request")
public class AddMemberTeamDTO {

    @Schema(description = "The ID of the employee to add to the team", example = "1")
    private Long employeeId;

    @Schema(description = "The role of the employee in the team", implementation = TeamRole.class, example = "DEVELOPER")
    private TeamRole role;

}
