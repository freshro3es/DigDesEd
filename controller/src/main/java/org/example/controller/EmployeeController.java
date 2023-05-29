package org.example.controller;

import org.example.dto.CreateEmployeeDTO;
import org.example.dto.OrderEmployeeDTO;
import org.example.dto.UpdateEmployeeDTO;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<OrderEmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/filter")
    public List<OrderEmployeeDTO> getAllEmployeesWithParam(OrderEmployeeDTO orderEmployeeDTO) {
        return employeeService.getAllEmployeesWithParam(orderEmployeeDTO);
    }

    @GetMapping("/{id}")
    public OrderEmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        employeeService.saveEmployee(createEmployeeDTO);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeDTO updateEmployeeDTO) {
        employeeService.updateEmployee(id, updateEmployeeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }
}
