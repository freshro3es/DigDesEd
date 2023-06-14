package org.example.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.TaskStatus;

import java.util.Date;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter @Setter @AllArgsConstructor @ToString
@Schema(description = "Class representing a task object representation response")
public class OrderTaskDTO {

    @Schema(description = "ID of the task", example = "12")
    private Long id;

    @Schema(description = "ID of the employee assigned to the task", example = "5")
    private Long employeeId;

    @Schema(description = "ID of the project the task belongs to", example = "2")
    private Long projectId;

    @Schema(description = "Name of the task", example = "Update Homepage Content")
    private String name;

    @Schema(description = "Description of the task", example = "Update the text and images on the homepage.")
    private String description;

    @Schema(description = "ID of the author of the task", example = "1")
    private Long authorId;

    @Schema(description = "Status of the task", example = "IN_PROGRESS")
    private TaskStatus status;

    @Schema(description = "Date the task was created", example = "2022-01-01")
    private Date creationDate;

    @Schema(description = "Number of labour hours of the task", example = "8")
    private Long labourHours;

    @Schema(description = "Deadline for the task", example = "2022-01-08")
    private Date deadline;

    @Schema(description = "Last date the task was updated", example = "2022-01-05")
    private Date updateDate;

}
