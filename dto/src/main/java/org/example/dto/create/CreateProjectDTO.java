package org.example.dto.create;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateProjectDTO {

    private final String name;

    @JsonCreator
    public CreateProjectDTO(@JsonProperty("name") String name) {
        this.name = name;
    }

}
