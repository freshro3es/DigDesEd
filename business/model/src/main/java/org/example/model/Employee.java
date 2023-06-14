package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.libs.EmpStatus;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(
            name = "firstname",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "lastname",
            nullable = false
    )
    private String lastName;

    @Column(name = "fathername")
    private String fatherName;

    @Column(name = "position")
    private String position;

    @Column(name = "account", unique = true)
    private String account;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EmpStatus empStatus;

    @Column(
            name = "password",
            nullable = false
    )
    private String password;

    @Column(name = "is_temporary_pwd")
    private boolean isTemporaryPwd;

//    @Enumerated(EnumType.STRING)
//    private TeamRole role;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmployeeInTeam> employeeInTeams;

    @OneToMany(mappedBy = "employee", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<Task> tasks;

//    @ManyToMany(mappedBy="employees")
//    private List<Team> teams;

}
