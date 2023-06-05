package org.example.repository;

import org.example.libs.EmpStatus;
import org.example.model.Employee;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    @Query("SELECT e FROM Employee e WHERE (e.firstName LIKE %?1%"
//            + " OR e.lastName LIKE %?1%"
//            + " OR e.fatherName LIKE %?1%"
//            + " OR e.account LIKE %?1%"
//            + " OR e.email LIKE %?1% )"
//            + " AND e.empStatus = org.example.libs.EmpStatus.ACTIVE ")
//    List<Employee> search(String keyword);

    @Query("SELECT e FROM Employee e WHERE "
            + "(e.firstName LIKE %:keyword% OR "
            + "e.lastName LIKE %:keyword% OR "
            + "e.fatherName LIKE %:keyword% OR "
            + "e.account LIKE %:keyword% OR "
            + "e.email LIKE %:keyword% ) "
            + "AND e.empStatus = :empStatus ")
    List<Employee> search(@Param("keyword") String keyword, @Param("empStatus") EmpStatus empStatus);
}


