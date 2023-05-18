package org.example.dto;

import org.example.libs.TaskStat;

import java.util.Date;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter @AllArgsConstructor
public class OrderTaskDTO {

    private int employeeId;
    private int projectId;
    private String name;
    private String description;
    private int authorId;
    private String author;
    private TaskStat status;
    private Date creationDate;
    private int labourHours;
    private Date deadline;
    private Date updateDate;

}
