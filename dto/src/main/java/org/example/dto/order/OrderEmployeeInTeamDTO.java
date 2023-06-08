package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.libs.EmpStatus;

import lombok.Getter;
import org.example.libs.TeamRole;

@Getter
public class OrderEmployeeInTeamDTO {
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

    @JsonProperty("teamRole")
    private TeamRole teamRole;

    @JsonProperty("status")
    private EmpStatus status;

    public OrderEmployeeInTeamDTO(String firstName, String lastName, String fatherName, String position,
                            String account, String email, TeamRole teamRole, EmpStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.position = position;
        this.account = account;
        this.email = email;
        this.teamRole = teamRole;
        this.status = status;
    }
}
