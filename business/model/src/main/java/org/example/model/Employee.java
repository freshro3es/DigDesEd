package org.example.model;

import java.io.Serializable;

public class Employee extends Model implements Serializable {

    private String firstName;
    private String lastName;
    private String fatherName;
    private String position;
    private String account;
    private String email;
    private EmpStat empStat;

    public Employee(String firstName, String lastName, String fatherName, String position, String account, String email, EmpStat empStat) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.position = position;
        this.account = account;
        this.email = email;
        this.empStat = empStat;
    }
}
