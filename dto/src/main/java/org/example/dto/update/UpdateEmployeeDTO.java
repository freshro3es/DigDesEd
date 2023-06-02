package org.example.dto.update;

import org.example.libs.EmpStatus;
import org.example.libs.TeamRole;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter @AllArgsConstructor
public class UpdateEmployeeDTO {

    private String firstName;
    private String lastName;
    private String fatherName;
    private String position;
    private String account;
    private String email;
    private EmpStatus status;

}
