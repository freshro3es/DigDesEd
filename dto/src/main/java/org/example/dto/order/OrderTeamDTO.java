package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
public class OrderTeamDTO {

    @JsonProperty("firstName")
    private String name;

    public OrderTeamDTO(String name) {
        this.name = name;
    }
}
