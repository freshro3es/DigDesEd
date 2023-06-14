package org.example.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.TaskStatus;

import java.util.Date;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter @Setter @NoArgsConstructor @ToString
public class CreateTaskDTO {

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 100, message = "name length must be between 2 and 100 characters")
    @Schema(description = "The name of the task.", example = "Finish project")
    private String name;

    @NotNull(message = "Name cannot be null")
    @Positive
    @Schema(description = "The ID of the user creating the task.", example = "1")
    private Long authorId;

    @NotNull
    @Schema(description = "The current status of the task.", example = "NEW")
    private TaskStatus status = TaskStatus.NEW;

    @NotNull
    @Schema(description = "The date and time when the task was created.", example = "2021-10-01T12:00:00.000Z")
    private Date creationDate;

    @Positive
    @Schema(description = "The estimated labour hours for the task.", example = "12")
    private Long labourHours;

    @NotNull
    @Schema(description = "The deadline for the task.", example = "2021-10-14T12:00:00.000Z")
    private Date deadline;

}
