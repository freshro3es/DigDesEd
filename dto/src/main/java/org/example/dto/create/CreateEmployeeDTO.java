package org.example.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.libs.EmpStatus;

import lombok.Getter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter @Setter @NoArgsConstructor @ToString
@Schema(description = "Class representing a create employee request")
public class CreateEmployeeDTO {

    @NotBlank(message = "Firstname cannot be null")
    @Size(min = 2, max = 100, message = "Firstname length must be between 2 and 100 characters")
    @Schema(description = "Firstname of the new employee", example = "John")
    private String firstname;

    @NotBlank(message = "Lastname cannot be null")
    @Size(min = 2, max = 100, message = "Lastname length must be between 4 and 20 characters")
    @Schema(description = "Lastname of the new employee", example = "Doe")
    private String lastname;

    @NotBlank(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    @Schema(description = "Email of the new employee", example = "johndoe@example.com")
    private String email;

    @NotBlank(message = "password cannot be null")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Schema(description = "Password of the new employee", example = "password")
    private String password;

    @Schema(description = "Employee status", example = "ACTIVE")
    private final EmpStatus status = EmpStatus.ACTIVE;
}
