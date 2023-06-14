package org.example.specification;

import jakarta.persistence.criteria.Predicate;
import org.example.model.Employee;
import org.example.model.EmployeeInTeam;
import org.example.model.Team;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeInTeamSpecification {

    public static Specification<EmployeeInTeam> findAllByTeamId(Team team) {
        return (root, query, builder) -> {
            Predicate teamIdPredicate = builder.or(
                    builder.equal(root.get("team"), team)
            );
            return builder.and(teamIdPredicate);
        };
    }

    public static Specification<EmployeeInTeam> findAllByEmployeeId(Employee employee) {
        return (root, query, builder) -> {
            Predicate employeeIdPredicate = builder.or(
                    builder.equal(root.get("employee"), employee)
            );
            return builder.and(employeeIdPredicate);
        };
    }

    public static Specification<EmployeeInTeam> findByTeamAndEmployeeId(Team team, Employee employee) {
        return (root, query, builder) -> {
            Predicate employeeIdPredicate = builder.and(
                    builder.equal(root.get("team"), team),
                    builder.equal(root.get("employee"), employee)

            );
            return builder.and(employeeIdPredicate);
        };
    }

}
