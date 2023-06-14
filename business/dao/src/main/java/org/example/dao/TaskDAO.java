package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Employee;
import org.example.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAO {

    private final EntityManager entityManager;

    @Autowired
    public TaskDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Task save(Task task) {
        entityManager.persist(task);
        return task;
    }

    public Task update(Task task) {
        entityManager.merge(task);
        return task;
    }

    public void delete(Task task) {
        entityManager.remove(task);
    }

    public Task findById(int id) {
        return entityManager.find(Task.class, id);
    }

    public List<Task> findByEmployee(Employee employee) {
        TypedQuery<Task> query = entityManager.createQuery("SELECT t FROM Task t WHERE t.employee = :employee", Task.class);
        query.setParameter("employee", employee);
        return query.getResultList();
    }

    public List<Task> findByProject(int projectId) {
        TypedQuery<Task> query = entityManager.createQuery("SELECT t FROM Task t WHERE t.projectId = :projectId", Task.class);
        query.setParameter("projectId", projectId);
        return query.getResultList();
    }

    public List<Task> findAll() {
        TypedQuery<Task> query = entityManager.createQuery("SELECT t FROM Task t", Task.class);
        return query.getResultList();
    }
}
