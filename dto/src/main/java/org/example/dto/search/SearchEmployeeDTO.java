package org.example.dto.search;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@Schema(description = "Class representing a search employee request")
public class SearchEmployeeDTO {

    @Schema(description = "Search term used to search for employees", example = "John")
    private String search;

}
