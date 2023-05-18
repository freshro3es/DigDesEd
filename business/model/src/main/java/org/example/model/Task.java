package org.example.model;

import org.example.libs.TaskStat;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Task implements Serializable {

    private final int id;
    private int employeeId;
    private int projectId;
    private String name;
    private String description;
    private int authorId;
    private String author;
    private TaskStat status;
    private Date creationDate;
    private int labourHours;
    @Setter(lombok.AccessLevel.NONE)
    private Date deadline;
    private Date updateDate;

    public Task(int id,
                int employeeId,
                int projectId,
                String name,
                String description,
                int authorId,
                String author,
                TaskStat status,
                Date creationDate,
                int labourHours,
                Date deadline,
                Date updateDate
    ) {
        this.id = id;
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.authorId = authorId;
        this.author = author;
        this.status = status;
        this.creationDate = creationDate;
        this.labourHours = labourHours;
        if (isValidDeadline(deadline)) {
            this.deadline = deadline;
        }
        this.updateDate = updateDate;
    }

    public void setDeadline(Date deadline) {
        if (isValidDeadline(deadline)) {
            this.deadline = deadline;
        }
    }

    public boolean isValidDeadline(Date deadline) {
        long deadlineMs = deadline.getTime();
        long expectedDeadlineMs = getCreationDate().getTime() + ((long) getLabourHours() * 60 * 60 * 1000);
        return deadlineMs > expectedDeadlineMs;
    }
}
