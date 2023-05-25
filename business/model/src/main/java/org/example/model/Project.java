package org.example.model;

import lombok.*;
import org.example.libs.ProjStatus;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "project")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProjStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_team")
    private Team team;
}
