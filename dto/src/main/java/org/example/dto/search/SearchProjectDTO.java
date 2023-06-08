package org.example.dto.search;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.libs.ProjStatus;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class SearchProjectDTO {

    private String search;
    private List<ProjStatus> statuses;

}
