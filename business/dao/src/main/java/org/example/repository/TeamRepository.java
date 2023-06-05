package org.example.repository;

import org.example.libs.TeamRole;
import org.example.model.EmployeeInTeam;
import org.example.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

//    @Modifying(flushAutomatically = true, clearAutomatically = true)
//    @Query("INSERT INTO EmployeeInTeam(e.employee.id, e.team.id, e.role) VALUES (:employeeId, :teamId, :role)")
//    void addEmployeeToTeam(@Param("teamId") Long teamId, @Param("employeeId") Long employeeId, @Param("role") TeamRole role);
//
//    @Modifying(flushAutomatically = true, clearAutomatically = true)
//    @Query("DELETE FROM EmployeeInTeam e WHERE e.employee.id = :employeeId AND e.team.id = :teamId")
//    void removeEmployeeFromTeam(@Param("teamId") Long teamId, @Param("employeeId") Long employeeId);
//
//    @Query("SELECT e FROM EmployeeInTeam e WHERE e.team.id = :teamId")
//    List<EmployeeInTeam> getEmployeesInTeam(@Param("teamId") Long teamId);
}
