package org.example.dto.search;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.ProjStatus;

import java.util.List;

@Getter @Setter @NoArgsConstructor @ToString
@Schema(description = "Class representing a search project request")
public class SearchProjectDTO {

    @Schema(description = "Search term used to search for projects", example = "My Project")
    private String search;

    @Schema(description = "List of project statuses that should be included in the search", example = "[\"COMPLETED\", \"IN_PROGRESS\"]")
    private List<ProjStatus> statuses;

}
