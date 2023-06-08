package org.example.dto.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.libs.ProjStatus;

@Getter
public class StatusProjectDTO {

    private final ProjStatus status;

    @JsonCreator
    public StatusProjectDTO(@JsonProperty("status") ProjStatus status) {
        this.status = status;
    }

}
