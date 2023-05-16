package org.example.dto;

import org.example.libs.TaskStat;

import java.util.Date;

public class TaskDto {
    private final int id;
    private int employeeId;
    private int projectId;
    private String name;
    private String description;
    private int authorId;
    private String author;
    private TaskStat status;
    private Date creationDate;
    private Date deadline;
    private int labourHours;
    private Date updateDate;

    public TaskDto(int id,
                String name,
                String description,
                int authorId,
                String author,
                TaskStat status,
                Date creationDate,
                Date deadline,
                int labourHours,
                Date updateDate
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.authorId = authorId;
        this.author = author;
        this.status = status;
        this.creationDate = creationDate;
        this.deadline = deadline;
        this.labourHours = labourHours;
        this.updateDate = updateDate;
    }

    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public TaskStat getStatus() {
        return status;
    }

    public void setStatus(TaskStat status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getLabourHours() {
        return labourHours;
    }

    public void setLabourHours(int labourHours) {
        this.labourHours = labourHours;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
