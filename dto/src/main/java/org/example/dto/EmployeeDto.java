package org.example.dto;

import org.example.libs.EmpStat;
import org.example.libs.TeamRole;
import org.example.model.Task;

import java.util.List;

public class EmployeeDto {

    private final int id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String position;
    private String account;
    private String email;
    private EmpStat empStat;
    private TeamRole role;
    private List<Task> tasks;

    public EmployeeDto(
            int id,
            String firstName,
            String lastName,
            String fatherName,
            String position,
            String account,
            String email,
            EmpStat empStat,
            TeamRole role,
            List<Task> tasks
            ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.position = position;
        this.account = account;
        this.email = email;
        this.empStat = empStat;
        this.role = role;
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmpStat getEmpStat() {
        return empStat;
    }

    public void setEmpStat(EmpStat empStat) {
        this.empStat = empStat;
    }

    public TeamRole getRole() {
        return role;
    }

    public void setRole(TeamRole role) {
        this.role = role;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
