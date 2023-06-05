package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class SearchEmployeeDTO {

    private final String search;

    @JsonCreator
    public SearchEmployeeDTO(@JsonProperty("search") String search) {
        this.search = search;
    }

}
