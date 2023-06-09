package org.example.dto.create;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.TaskStatus;

import java.util.Date;
import lombok.Getter;

@Getter @Setter @NoArgsConstructor @ToString
public class CreateTaskDTO {

    private String name;
    private Long authorId;
    private TaskStatus status = TaskStatus.NEW;
    private Date creationDate;
    private Long labourHours;
    private Date deadline;

}
