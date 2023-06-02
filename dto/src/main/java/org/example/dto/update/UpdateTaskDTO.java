package org.example.dto.update;


import lombok.AllArgsConstructor;
import org.example.libs.TaskStatus;

import java.util.Date;
import lombok.Getter;

@Getter @AllArgsConstructor
public class UpdateTaskDTO {

    private int employeeId;
    private int projectId;
    private String name;
    private String description;
    private TaskStatus status;
    private int labourHours;
    private Date deadline;

}
