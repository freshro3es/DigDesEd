package org.example.model;

import org.example.libs.TaskStat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private final int id = 1;
    private int employeeId = 22;
    private int projectId = 5;
    private String name = "Сделать Docker image проекта";
    private String description = "Дядь, сам разберешься";
    private int authorId = 6;
    private String author = "Юра";
    private TaskStat status = TaskStat.NEW;
    private Date creationDate = Date.valueOf("2021-06-30");
    private int labourHours = 60;
    private Date deadline = Date.valueOf("2022-06-30");
    private Date updateDate = Date.valueOf("2021-12-15");

    @Test
    void createTaskValidDeadline() {
        Date deadline = Date.valueOf("2020-06-30");

        Task task = new Task(id, employeeId, projectId, name, description, authorId, author, status, creationDate, labourHours, deadline, updateDate);
        assertEquals(task.toString(), "Task(id=1, employeeId=22, projectId=5, name=Сделать Docker image проекта, " +
                "description=Дядь, сам разберешься, authorId=6, author=Юра, status=NEW, creationDate=2021-06-30, " +
                "labourHours=60, deadline=null, updateDate=2021-12-15)");
    }

    @Test
    void createTaskInvalidDeadline() {
        Task task = new Task(id, employeeId, projectId, name, description, authorId, author, status, creationDate, labourHours, deadline, updateDate);
        assertEquals(task.toString(), "Task(id=1, employeeId=22, projectId=5, name=Сделать Docker image проекта, " +
                                "description=Дядь, сам разберешься, authorId=6, author=Юра, status=NEW, creationDate=2021-06-30, " +
                                "labourHours=60, deadline=2022-06-30, updateDate=2021-12-15)");
    }

    @Test
    void setDeadline() {
        Task task = new Task(id, employeeId, projectId, name, description, authorId, author, status, creationDate, labourHours, deadline, updateDate);
        task.setDeadline(Date.valueOf("2021-07-01"));
        assertEquals(task.toString(), "Task(id=1, employeeId=22, projectId=5, name=Сделать Docker image проекта, " +
                "description=Дядь, сам разберешься, authorId=6, author=Юра, status=NEW, creationDate=2021-06-30, " +
                "labourHours=60, deadline=2022-06-30, updateDate=2021-12-15)");

        task.setDeadline(Date.valueOf("2022-06-30"));
        assertEquals(task.toString(), "Task(id=1, employeeId=22, projectId=5, name=Сделать Docker image проекта, " +
                "description=Дядь, сам разберешься, authorId=6, author=Юра, status=NEW, creationDate=2021-06-30, " +
                "labourHours=60, deadline=2022-06-30, updateDate=2021-12-15)");
    }

//    @Test
//    void isValidDeadline() {
//
//    }
}