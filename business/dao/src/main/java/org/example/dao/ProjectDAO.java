package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAO {

    private final EntityManager entityManager;

    @Autowired
    public ProjectDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Project save(Project project) {
        entityManager.persist(project);
        return project;
    }

    public Project update(Project project) {
        entityManager.merge(project);
        return project;
    }

    public void delete(Project project) {
        entityManager.remove(project);
    }

    public Project findById(int id) {
        return entityManager.find(Project.class, id);
    }

    public List<Project> findAll() {
        TypedQuery<Project> query = entityManager.createQuery("SELECT p FROM Project p", Project.class);
        return query.getResultList();
    }
}