package org.example.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @ToString
@Schema(description = "Class representing a team object representation response")
public class OrderTeamDTO {

    @Schema(description = "ID of the team", example = "1")
    private Long id;

    @Schema(description = "Name of the team", example = "Software Development Team A")
    private String name;

}
