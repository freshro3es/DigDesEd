package org.example.repository;

import org.example.model.EmployeeInTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInTeamRepository extends JpaRepository<EmployeeInTeam, Long> {
}
