package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.libs.EmpStatus;
import org.example.libs.TeamRole;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(
        name = "employee",
        uniqueConstraints = @UniqueConstraint(
                name = "account_unique",
                columnNames = "account"
        )
)
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Employee implements Serializable {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
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

    @Column(name = "account")
    private String account;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "status",
            nullable = false
    )
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
