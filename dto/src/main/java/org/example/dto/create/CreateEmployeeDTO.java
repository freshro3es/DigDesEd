package org.example.dto.create;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.libs.EmpStatus;

import lombok.Getter;

@Getter @Setter @NoArgsConstructor
public class CreateEmployeeDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private final EmpStatus status = EmpStatus.ACTIVE;

}
