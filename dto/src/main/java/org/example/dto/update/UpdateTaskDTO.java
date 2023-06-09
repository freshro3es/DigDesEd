package org.example.dto.update;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import lombok.Getter;

@Getter @Setter @NoArgsConstructor @ToString
public class UpdateTaskDTO {

    private Long employeeId;
    private Long projectId;
    private String name;
    private String description;
    private Long labourHours;
    private Date deadline;

}
