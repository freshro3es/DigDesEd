package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.example.model.Employee;
import org.example.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Employee> findAll() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    public List<Employee> findAllWithParam(String firstName, String lastName, String fatherName, String position,
                                  String account, String email, String status, String role) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = cq.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        if (firstName != null) {
            predicates.add(cb.equal(employeeRoot.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicates.add(cb.equal(employeeRoot.get("lastName"), lastName));
        }
        if (fatherName != null) {
            predicates.add(cb.equal(employeeRoot.get("fatherName"), fatherName));
        }
        if (position != null) {
            predicates.add(cb.equal(employeeRoot.get("position"), position));
        }
        if (account != null) {
            predicates.add(cb.equal(employeeRoot.get("account"), account));
        }
        if (email != null) {
            predicates.add(cb.equal(employeeRoot.get("email"), email));
        }
        if (status != null) {
            predicates.add(cb.equal(employeeRoot.get("status"), status));
        }
        if (role != null) {
            Join<Employee, Team> employeeTeamJoin = employeeRoot.join("team");
            predicates.add(cb.equal(employeeTeamJoin.get("role"), role));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    public void delete(Employee employee) {
        entityManager.remove(employee);
    }
}