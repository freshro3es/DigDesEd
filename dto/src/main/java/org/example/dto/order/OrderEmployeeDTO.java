package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.libs.EmpStatus;

import lombok.Getter;

@Getter
public class OrderEmployeeDTO {
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("fatherName")
    private String fatherName;

    @JsonProperty("position")
    private String position;

    @JsonProperty("account")
    private String account;

    @JsonProperty("email")
    private String email;

    @JsonProperty("status")
    private EmpStatus status;

    public OrderEmployeeDTO(String firstName, String lastName, String fatherName, String position,
                            String account, String email, EmpStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.position = position;
        this.account = account;
        this.email = email;
        this.status = status;
    }
}