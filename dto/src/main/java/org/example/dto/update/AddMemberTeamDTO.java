package org.example.dto.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.libs.TeamRole;

@Getter
public class AddMemberTeamDTO {

    private final Long employeeId;
    private final TeamRole role;

    @JsonCreator
    public AddMemberTeamDTO(
            @JsonProperty("employeeId") Long employeeId,
            @JsonProperty("role") TeamRole role
    ) {
        this.employeeId = employeeId;
        this.role = role;
    }
}
