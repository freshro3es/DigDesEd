package org.example.dto.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.libs.ProjStatus;

import lombok.Getter;


@Getter
public class UpdateProjectDTO {

    private final String name;
    private final String description;
    private final ProjStatus status;
    private final Long teamId;

    @JsonCreator
    public UpdateProjectDTO(@JsonProperty("name") String name,
                            @JsonProperty("description") String description,
                            @JsonProperty("status") ProjStatus status,
                            @JsonProperty("teamId") Long teamId) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.teamId = teamId;
    }

}
