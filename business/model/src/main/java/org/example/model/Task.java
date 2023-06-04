package org.example.model;

import org.example.libs.TaskStatus;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "task")
@Getter @Setter @ToString @NoArgsConstructor
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_employee")
    private Employee employee;

    @Column(name = "fk_project")
    private Long projectId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "author")
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "labour_hours") //TODO не ясно, как поведет себя это поле, нужно протестировать
    private Long labourHours;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deadline")
    private Date deadline;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    public Task(Long projectId,
                String name,
                String description,
                Long authorId,
                String author,
                TaskStatus status,
                Date creationDate,
                Long labourHours,
                Date deadline,
                Date updateDate
    ) {
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
        long expectedDeadlineMs = getCreationDate().getTime() + (getLabourHours() * 60 * 60 * 1000);
        return deadlineMs > expectedDeadlineMs;
    }

}
