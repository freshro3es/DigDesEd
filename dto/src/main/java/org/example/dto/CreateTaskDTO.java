package org.example.dto;

import lombok.AllArgsConstructor;
import org.example.libs.TaskStat;

import java.util.Date;
import lombok.Getter;

@Getter @AllArgsConstructor
public class CreateTaskDTO {

    private String name;
    private int authorId;
    private TaskStat status;
    private Date creationDate;
    private int labourHours;
    private Date deadline;

}
