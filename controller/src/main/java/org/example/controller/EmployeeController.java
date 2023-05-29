package org.example.controller;

import org.example.dto.CreateEmployeeDTO;
import org.example.dto.OrderEmployeeDTO;
import org.example.dto.UpdateEmployeeDTO;
import org.example.mapper.EmployeeMapper;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping
    public List<OrderEmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return employees.stream()
                .map(employeeMapper::toOrderEmployeeDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderEmployeeDTO getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employeeMapper.toOrderEmployeeDTO(employee);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        Employee employee = employeeMapper.toEmployee(createEmployeeDTO);
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeDTO updateEmployeeDTO) {
        Employee employee = employeeMapper.toEmployee(updateEmployeeDTO);
        employee.setId(id);
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        employeeService.deleteEmployee(employee);
    }
}
