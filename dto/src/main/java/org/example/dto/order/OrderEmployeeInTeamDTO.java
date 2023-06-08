package org.example.dto.order;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.example.libs.EmpStatus;

import lombok.Getter;
import org.example.libs.TeamRole;

@Getter @Setter @AllArgsConstructor
public class OrderEmployeeInTeamDTO {

    private String firstName;
    private String lastName;
    private String fatherName;
    private String position;
    private String account;
    private String email;
    private TeamRole teamRole;
    private EmpStatus status;

}
