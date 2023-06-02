package org.example.model;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "team")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<EmployeeInTeam> employeeInTeams;

    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL)
    private Project project;
}
