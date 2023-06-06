package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SearchTeamDTO {

    private final String search;

    @JsonCreator
    public SearchTeamDTO(@JsonProperty("search") String search) {
        this.search = search;
    }
}
