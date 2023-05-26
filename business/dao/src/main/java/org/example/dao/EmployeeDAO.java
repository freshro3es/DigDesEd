package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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