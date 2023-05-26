package org.example.service;

import org.example.dao.TeamDAO;
import org.example.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamDAO teamDao;

    public Team create(Team team) {
        return teamDao.save(team);
    }

    public Team update(Team team) {
        return teamDao.update(team);
    }

    public void delete(int id) {
        teamDao.delete(findById(id));
    }

    public Team findById(int id) {
        return teamDao.findById(id);
    }

    public List<Team> findAll() {
        return teamDao.findAll();
    }
}

