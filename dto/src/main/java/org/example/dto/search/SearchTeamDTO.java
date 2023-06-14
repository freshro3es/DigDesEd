package org.example.dto.search;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor @ToString
@Schema(description = "Class representing a search team request")
public class SearchTeamDTO {

    @Schema(description = "Search term used to search for teams", example = "My Team")
    private String search;

}
