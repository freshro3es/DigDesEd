package org.example.service;

import org.example.dao.ProjectDAO;
import org.example.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectDAO projectDao;

    public Project create(Project project) {
        return projectDao.save(project);
    }

    public Project update(Project project) {
        return projectDao.update(project);
    }

    public void delete(int id) {
        Project project = projectDao.findById(id);
        if (project != null) {
            projectDao.delete(project);
        }
    }

    public Project findById(int id) {
        return projectDao.findById(id);
    }

    public List<Project> findAll() {
        return projectDao.findAll();
    }
}
