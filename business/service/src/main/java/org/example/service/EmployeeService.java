package org.example.service;

import org.example.dto.create.CreateEmployeeDTO;
import org.example.dto.order.OrderEmployeeDTO;
import org.example.dto.search.SearchEmployeeDTO;
import org.example.dto.update.UpdateEmployeeDTO;
import org.example.libs.EmpStatus;
import org.example.mapper.EmployeeMapper;
import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<OrderEmployeeDTO> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::toOrderEmployeeDTO).collect(Collectors.toList());
    }

    public OrderEmployeeDTO findById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.map(employee -> employeeMapper.toOrderEmployeeDTO(employee)).orElse(null);
    }

    public List<OrderEmployeeDTO> search(SearchEmployeeDTO searchEmployeeDTO) {
        System.out.println(searchEmployeeDTO.getSearch());
        List<Employee> employees = employeeRepository.search(searchEmployeeDTO.getSearch(), EmpStatus.ACTIVE);
        System.out.println(employees);
        return employees.stream().map(employeeMapper::toOrderEmployeeDTO).collect(Collectors.toList());
    }

    public Employee save(CreateEmployeeDTO createEmployeeDTO) {
        Employee employee = employeeMapper.toEmployee(createEmployeeDTO);
        employee = employeeRepository.save(employee);
        return employee;
    }

    public Employee update(Long id, UpdateEmployeeDTO updateEmployeeDTO) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employeeMapper.updateEmployeeDTOToEmployee(updateEmployeeDTO, employee);
            employeeRepository.save(employee);
            return employee;
        }
        return null;
    }

    public Employee delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        employeeRepository.deleteById(id);
        return employee;
    }
}
