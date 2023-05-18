package org.example.model;

import org.example.libs.EmpStatus;
import org.example.libs.TeamRole;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter @Setter @ToString @AllArgsConstructor
public class Employee implements Serializable {

    private final int id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String position;
    private String account;
    private String email;
    private EmpStatus empStatus;
    private String password;
    private boolean isTemporaryPwd;
    private TeamRole role;
    private List<Task> tasks;

}
