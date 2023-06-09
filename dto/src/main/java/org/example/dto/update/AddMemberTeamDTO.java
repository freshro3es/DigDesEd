package org.example.dto.update;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.TeamRole;

@Getter @Setter @NoArgsConstructor @ToString
public class AddMemberTeamDTO {

    private Long employeeId;
    private TeamRole role;

}
