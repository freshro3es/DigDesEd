package org.example.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.EmpStatus;
import lombok.Getter;

@Getter @Setter @NoArgsConstructor @ToString
@Schema(description = "Class representing an update employee request")
public class UpdateEmployeeDTO {

    @Schema(description = "The first name of the employee", example = "John")
    private String firstName;

    @Schema(description = "The last name of the employee", example = "Doe")
    private String lastName;

    @Schema(description = "The father name of the employee", example = "Jack")
    private String fatherName;

    @Schema(description = "The position of the employee", example = "Software Engineer")
    private String position;

    @Schema(description = "The account of the employee", example = "john_doe")
    private String account;

    @Schema(description = "The email of the employee", example = "john.doe@example.com")
    private String email;

    @Schema(description = "The status of the employee", implementation = EmpStatus.class)
    private EmpStatus status;

}
