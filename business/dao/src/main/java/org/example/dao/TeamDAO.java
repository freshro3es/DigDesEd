package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDAO {

    private final EntityManager entityManager;

    @Autowired
    public TeamDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Team save(Team team) {
        entityManager.persist(team);
        return team;
    }

    public Team update(Team team) {
        return entityManager.merge(team);
    }

    public void delete(Team team) {
        entityManager.remove(team);
    }

    public Team findById(int id) {
        return entityManager.find(Team.class, id);
    }

    public List<Team> findAll() {
        TypedQuery<Team> query = entityManager.createQuery("SELECT t FROM Team t", Team.class);
        return query.getResultList();
    }
}

