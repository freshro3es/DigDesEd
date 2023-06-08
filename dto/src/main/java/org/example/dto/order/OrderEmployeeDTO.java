package org.example.dto.order;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.example.libs.EmpStatus;

import lombok.Getter;

@Getter @Setter @AllArgsConstructor
public class OrderEmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String position;
    private String account;
    private String email;
    private EmpStatus status;

}