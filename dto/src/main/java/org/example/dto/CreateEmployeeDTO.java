package org.example.dto;

import org.example.libs.EmpStatus;

import lombok.Getter;

@Getter
public class CreateEmployeeDTO {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final EmpStatus status;

    public CreateEmployeeDTO(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password; //Здесь будет функция хеширования
        this.status = EmpStatus.ACTIVE;
    }
}
