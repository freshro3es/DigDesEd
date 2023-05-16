package org.example.dto;

import org.example.libs.EmpStat;

public class RegistrationRequest {

    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final EmpStat status;

    public RegistrationRequest(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password; //Здесь будет функция хеширования
        this.status = EmpStat.ACTIVE;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public EmpStat getStatus() {
        return status;
    }
}
