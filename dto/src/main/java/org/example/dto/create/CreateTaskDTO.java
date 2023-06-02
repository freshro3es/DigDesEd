package org.example.dto.create;

import lombok.AllArgsConstructor;
import org.example.libs.TaskStatus;

import java.util.Date;
import lombok.Getter;

@Getter @AllArgsConstructor
public class CreateTaskDTO {

    private String name;
    private Long authorId;
    private TaskStatus status;
    private Date creationDate;
    private int labourHours;
    private Date deadline;

}
