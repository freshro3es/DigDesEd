package org.example.dto.order;

import lombok.Setter;
import lombok.ToString;
import org.example.libs.TaskStatus;

import java.util.Date;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter @Setter @AllArgsConstructor @ToString
public class OrderTaskDTO {

    private Long id;
    private Long employeeId;
    private Long projectId;
    private String name;
    private String description;
    private Long authorId;
    private TaskStatus status;
    private Date creationDate;
    private Long labourHours;
    private Date deadline;
    private Date updateDate;

}
