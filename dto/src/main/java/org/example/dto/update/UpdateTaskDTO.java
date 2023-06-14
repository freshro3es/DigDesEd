package org.example.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import lombok.Getter;

@Getter @Setter @NoArgsConstructor @ToString
@Schema(description = "Class representing an update task request")
public class UpdateTaskDTO {

    @Schema(description = "The ID of the employee who is assigned to complete this task", example = "12")
    private Long employeeId;

    @Schema(description = "The ID of the project that this task is associated with", example = "4")
    private Long projectId;

    @Schema(description = "The name of the task", example = "Implement login functionality")
    private String name;

    @Schema(description = "A brief description of what the task involves", example = "Create a form to allow users to enter credentials and authenticate against the server")
    private String description;

    @Schema(description = "The total number of labour hours that are estimated to complete this task", example = "12")
    private Long labourHours;

    @Schema(description = "The deadline for this task to be completed", example = "2022-01-01T00:00:00.000Z")
    private Date deadline;

}
