package org.example.dto.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.libs.EmpStatus;
import lombok.Getter;

@Getter
public class UpdateEmployeeDTO {

    private final String firstName;
    private final String lastName;
    private final String fatherName;
    private final String position;
    private final String account;
    private final String email;
    private final EmpStatus status;

    @JsonCreator
    public UpdateEmployeeDTO(@JsonProperty("firstName") String firstName,
                             @JsonProperty("lastName") String lastName,
                             @JsonProperty("fatherName") String fatherName,
                             @JsonProperty("position") String position,
                             @JsonProperty("account") String account,
                             @JsonProperty("email") String email,
                             @JsonProperty("status") EmpStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.position = position;
        this.account = account;
        this.email = email;
        this.status = status;
    }

}
