package org.example.service;

import org.example.dao.EmployeeDAO;
import org.example.dto.CreateEmployeeDTO;
import org.example.dto.OrderEmployeeDTO;
import org.example.dto.UpdateEmployeeDTO;
import org.example.mapper.EmployeeMapper;
import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<OrderEmployeeDTO> getAllEmployees() {
        return employeeDAO.findAll()
                .stream()
                .map(employeeMapper::toOrderEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<OrderEmployeeDTO> getAllEmployeesWithParam(OrderEmployeeDTO o) {
        List<Employee> employees = employeeDAO.findAllWithParam(
                o.getFirstName(),
                o.getLastName(),
                o.getFatherName(),
                o.getPosition(),
                o.getAccount(),
                o.getEmail(),
                o.getStatus().toString(),
                o.getRole().toString()
                );
        return employees.stream()
                .map(employeeMapper::toOrderEmployeeDTO)
                .collect(Collectors.toList());
    }

    public OrderEmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeDAO.findById(id);
        return employeeMapper.toOrderEmployeeDTO(employee);
    }

    public void saveEmployee(CreateEmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        employeeDAO.save(employee);
    }

    public void updateEmployee(Long id, UpdateEmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        employeeDAO.update(employee);
    }

    public void deleteEmployeeById(Long id) {
        Employee employee = employeeDAO.findById(id);
        employeeDAO.delete(employee);
    }
}
