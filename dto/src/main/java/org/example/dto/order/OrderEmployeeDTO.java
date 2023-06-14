package org.example.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.EmpStatus;

import lombok.Getter;

@Getter @Setter @AllArgsConstructor @ToString
@Schema(description = "Class representing a employee object representation response")
public class OrderEmployeeDTO {

    @Schema(description = "Employee ID", example = "1")
    private Long id;

    @Schema(description = "Employee's first name", example = "John")
    private String firstName;

    @Schema(description = "Employee's last name", example = "Doe")
    private String lastName;

    @Schema(description = "Employee's middle name", example = "Patrick")
    private String fatherName;

    @Schema(description = "Employee's job position", example = "manager")
    private String position;

    @Schema(description = "Employee's account name", example = "john.doeMan")
    private String account;

    @Schema(description = "Employee's email address", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Employee's status", example = "ACTIVE")
    private EmpStatus status;

}