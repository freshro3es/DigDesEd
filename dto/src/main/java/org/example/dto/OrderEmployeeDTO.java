package org.example.dto;

import org.example.libs.EmpStat;
import org.example.libs.TeamRole;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter @AllArgsConstructor
public class OrderEmployeeDTO {

    private String firstName;
    private String lastName;
    private String fatherName;
    private String position;
    private String account;
    private String email;
    private EmpStat empStat;
    private TeamRole role;

}
