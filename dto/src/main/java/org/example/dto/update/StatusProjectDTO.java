package org.example.dto.update;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.ProjStatus;

@Getter @Setter @NoArgsConstructor @ToString
public class StatusProjectDTO {

    private ProjStatus status;

}
