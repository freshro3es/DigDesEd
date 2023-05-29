package org.example.mapper;

import org.example.dto.CreateEmployeeDTO;
import org.example.dto.OrderEmployeeDTO;
import org.example.dto.UpdateEmployeeDTO;
import org.example.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    @Autowired
    private ModelMapper modelMapper;

    public OrderEmployeeDTO toOrderEmployeeDTO(Employee employee) {
        return modelMapper.map(employee, OrderEmployeeDTO.class);
    }

    public Employee toEmployee(CreateEmployeeDTO createEmployeeDTO) {
        return modelMapper.map(createEmployeeDTO, Employee.class);
    }

    public Employee toEmployee(UpdateEmployeeDTO updateEmployeeDTO) {
        return modelMapper.map(updateEmployeeDTO, Employee.class);
    }
}
