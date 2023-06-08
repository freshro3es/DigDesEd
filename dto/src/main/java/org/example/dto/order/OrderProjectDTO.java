package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.libs.ProjStatus;

import lombok.Getter;

@Getter
public class OrderProjectDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("status")
    private ProjStatus status;
    @JsonProperty("team")
    private String team;

    public OrderProjectDTO(String name, String description, ProjStatus status, String team) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.team = team;
    }
}
