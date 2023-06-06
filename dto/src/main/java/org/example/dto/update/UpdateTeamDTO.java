package org.example.dto.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UpdateTeamDTO {

    private final String name;

    @JsonCreator
    public UpdateTeamDTO(@JsonProperty("name") String name) {
        this.name = name;
    }
}
