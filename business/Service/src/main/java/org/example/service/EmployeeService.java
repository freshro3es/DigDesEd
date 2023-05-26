package org.example.service;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeDao.findById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeDao.delete(employee);
    }
}
