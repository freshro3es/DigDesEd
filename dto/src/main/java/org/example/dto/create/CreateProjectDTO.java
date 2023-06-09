package org.example.dto.create;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class CreateProjectDTO {

    private String code;
    private String name;

}
