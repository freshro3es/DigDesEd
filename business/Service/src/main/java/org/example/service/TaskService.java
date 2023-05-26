package org.example.service;

import org.example.dao.EmployeeDAO;
import org.example.dao.TaskDAO;
import org.example.model.Employee;
import org.example.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TaskService{

    @Autowired
    private TaskDAO taskDao;

    @Autowired
    private EmployeeDAO employeeDao;

    public Task create(Task task) {
        if (task.getEmployee() != null) {
            Employee employee = employeeDao.findById(task.getEmployee().getId());
            task.setEmployee(employee);
        }
        return taskDao.save(task);
    }

    public Task update(Task task) {
        if (task.getEmployee() != null) {
            Employee employee = employeeDao.findById(task.getEmployee().getId());
            task.setEmployee(employee);
        }
        return taskDao.update(task);
    }

    public void delete(int id) {
        Task task = taskDao.findById(id);
        if (task != null) {
            taskDao.delete(task);
        }
    }

    public Task findById(int id) {
        return taskDao.findById(id);
    }

    public List<Task> findByEmployee(Long employeeId) {
        Employee employee = employeeDao.findById(employeeId);
        if (employee != null) {
            return taskDao.findByEmployee(employee);
        }
        return Collections.emptyList();
    }

    public List<Task> findByProject(int projectId) {
        return taskDao.findByProject(projectId);
    }

    public List<Task> findAll() {
        return taskDao.findAll();
    }
}
