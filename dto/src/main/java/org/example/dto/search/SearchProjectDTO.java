package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.libs.ProjStatus;

import java.util.List;

@Getter
public class SearchProjectDTO {

    private final String search;

    private final List<ProjStatus> statuses;

    @JsonCreator
    public SearchProjectDTO(
            @JsonProperty("search") String search,
            @JsonProperty("statuses") List<ProjStatus> statuses) {
        this.search = search;
        this.statuses = statuses;
    }
}
