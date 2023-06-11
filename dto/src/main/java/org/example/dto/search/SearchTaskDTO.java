package org.example.dto.search;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.libs.TaskStatus;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Class representing a search task request")
public class SearchTaskDTO {

    @Schema(description = "Search term used to search for tasks", example = "My Task")
    private String search;

    @Schema(description = "List of task status filters that should be included in the search", example = "[\"COMPLETED\", \"IN_PROGRESS\"]")
    private List<TaskStatus> statusFilter;

    @Schema(description = "The ID of the employee assigned to the task", example = "1")
    private Long employeeId;

    @Schema(description = "The ID of the author of the task", example = "2")
    private Long authorId;

    @Schema(description = "Tasks with deadlines after this date will be included in the search", example = "2022-01-01")
    private Date deadlineFrom;

    @Schema(description = "Tasks with deadlines before this date will be included in the search", example = "2022-02-01")
    private Date deadlineTo;

    @Schema(description = "Tasks with creation dates equal to or after this date will be included in the search", example = "2022-01-01")
    private Date creationFrom;

    @Schema(description = "Tasks with creation dates equal to or before this date will be included in the search", example = "2022-02-01")
    private Date creationTo;

}
