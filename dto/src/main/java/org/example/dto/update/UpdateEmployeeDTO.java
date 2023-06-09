package org.example.dto.update;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.EmpStatus;
import lombok.Getter;

@Getter @Setter @NoArgsConstructor @ToString
public class UpdateEmployeeDTO {

    private String firstName;
    private String lastName;
    private String fatherName;
    private String position;
    private String account;
    private String email;
    private EmpStatus status;

}
