package org.example.dto.order;

import lombok.Setter;
import org.example.libs.TaskStatus;

import java.util.Date;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter @Setter @AllArgsConstructor
public class OrderTaskDTO {

    private int employeeId;
    private int projectId;
    private String name;
    private String description;
    private int authorId;
    private String author;
    private TaskStatus status;
    private Date creationDate;
    private int labourHours;
    private Date deadline;
    private Date updateDate;

}
