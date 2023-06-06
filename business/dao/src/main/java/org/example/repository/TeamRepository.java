package org.example.repository;

import org.example.libs.TeamRole;
import org.example.model.Employee;
import org.example.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT t FROM Team t WHERE t.name LIKE %:keyword%")
    List<Team> search(@Param("keyword") String keyword);

    @Query("SELECT e.employee FROM EmployeeInTeam e WHERE e.team.id = :teamId")
    List<Employee> getEmployeesInTeam(@Param("teamId") Long teamId);

//    @Transactional
//    @Modifying(flushAutomatically = true, clearAutomatically = true)
////    @Query("INSERT INTO EmployeeInTeam (team, employee, role) VALUES (:teamId, :employeeId, :role)")
//    @Query("INSERT INTO EmployeeInTeam (team_id, employee_id, role) " +
//            "SELECT t.id, e.id, :role " +
//            "FROM Team t, Employee e " +
//            "WHERE t.id = :teamId AND e.id = :employeeId")
//    void addEmployeeToTeam(@Param("teamId") Long teamId, @Param("employeeId") Long employeeId, @Param("role") TeamRole role);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("DELETE FROM EmployeeInTeam e WHERE e.employee.id = :employeeId AND e.team.id = :teamId")
    void removeEmployeeFromTeam(@Param("teamId") Long teamId, @Param("employeeId") Long employeeId);

}
