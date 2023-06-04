package org.example.repository;

import org.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE (e.firstName LIKE %?1%"
            + " OR e.lastName LIKE %?1%"
            + " OR e.fatherName LIKE %?1%"
            + " OR e.account LIKE %?1%"
            + " OR e.email LIKE %?1% )"
            + " AND e.empStatus = org.example.libs.EmpStatus.ACTIVE ")
    List<Employee> search(String keyword);
}
