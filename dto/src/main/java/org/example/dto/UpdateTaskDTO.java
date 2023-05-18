package org.example.dto;


import lombok.AllArgsConstructor;
import org.example.libs.TaskStat;

import java.util.Date;
import lombok.Getter;

@Getter @AllArgsConstructor
public class UpdateTaskDTO {

    private int employeeId;
    private int projectId;
    private String name;
    private String description;
    private TaskStat status;
    private int labourHours;
    private Date deadline;

}
