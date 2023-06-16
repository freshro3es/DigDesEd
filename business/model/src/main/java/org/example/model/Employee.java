package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.libs.EmpStatus;
import org.example.libs.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Employee implements Serializable, UserDetails {

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


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmployeeInTeam> employeeInTeams;

    @OneToMany(mappedBy = "employee", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<Task> tasks;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return account;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
