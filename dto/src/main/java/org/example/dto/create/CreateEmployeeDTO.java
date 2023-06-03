package org.example.dto.create;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.libs.EmpStatus;

import lombok.Getter;

@Getter
public class CreateEmployeeDTO {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final EmpStatus status;

    @JsonCreator
    public CreateEmployeeDTO(@JsonProperty("firstname") String firstname,
                             @JsonProperty("lastname") String lastname,
                             @JsonProperty("email") String email,
                             @JsonProperty("password") String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password; // Здесь будет функция хеширования
        this.status = EmpStatus.ACTIVE;
    }
}
