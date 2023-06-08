package org.example.dto.create;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.libs.TaskStatus;

import java.util.Date;
import lombok.Getter;

@Getter @Setter @NoArgsConstructor
public class CreateTaskDTO {

    private String name;
    private Long authorId;
    private TaskStatus status;
    private Date creationDate;
    private int labourHours;
    private Date deadline;

}
