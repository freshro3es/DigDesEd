package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.libs.TeamRole;

@Entity
@Table(name = "employee_in_team")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class EmployeeInTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", nullable = false)
    private TeamRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_employee", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_team", referencedColumnName = "id")
    private Team team;

}
