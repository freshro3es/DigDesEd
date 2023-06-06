package org.example.dto.create;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateTeamDTO {

    private final String name;

    @JsonCreator
    public CreateTeamDTO(@JsonProperty("name") String name) {
        this.name = name;
    }

}
