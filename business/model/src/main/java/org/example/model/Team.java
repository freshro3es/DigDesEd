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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_in_team",
            joinColumns = { @JoinColumn(name = "fk_employee") },
            inverseJoinColumns = { @JoinColumn(name = "fk_team") }
    )
    private List<Employee> employees;

    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL)
    private Project project;
}
