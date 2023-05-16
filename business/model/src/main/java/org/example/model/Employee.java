package org.example.model;

import org.example.libs.EmpStat;
import org.example.libs.TeamRole;

import java.io.Serializable;
import java.util.List;

public class Employee extends Model implements Serializable {

    private final int id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String position;
    private String account;
    private String email;
    private EmpStat empStat;
    private String password;
    private boolean isTemporaryPwd;
    private TeamRole role;
    private List<Task> tasks;

    //в конструкторе нет роли

    public Employee(
            int id,
            String firstName,
            String lastName,
            String fatherName,
            String position,
            String account,
            String email,
            EmpStat empStat,
            String password
            ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.position = position;
        this.account = account;
        this.email = email;
        this.empStat = empStat;
        this.password = password;
        this.isTemporaryPwd = true;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTemporaryPwd() {
        return isTemporaryPwd;
    }

    public void setTemporaryPwd(boolean temporaryPwd) {
        isTemporaryPwd = temporaryPwd;
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
