package org.example.dto.search;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.libs.TaskStatus;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SearchTaskDTO {

    private String search;
    private List<TaskStatus> statusFilter;
    private Long employeeId;
    private Long authorId;
    private Date deadlineFrom;
    private Date deadlineTo;
    private Date creationFrom;
    private Date creationTo;

}
