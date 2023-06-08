package org.example.mapper;

import org.example.dto.create.CreateEmployeeDTO;
import org.example.dto.order.OrderEmployeeDTO;
import org.example.dto.update.UpdateEmployeeDTO;
import org.example.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEmployee(CreateEmployeeDTO dto) {
        if (dto == null) {
            return null;
        }

        Employee employee = new Employee();

        employee.setFirstName(dto.getFirstname());
        employee.setLastName(dto.getLastname());
        employee.setEmail(dto.getEmail());
        employee.setPassword(dto.getPassword());
        employee.setEmpStatus(dto.getStatus());

        return employee;
    }

    public OrderEmployeeDTO toOrderEmployeeDTO(Employee employee) {
        if (employee == null) {
            return null;
        }
        return new OrderEmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getFatherName(),
                employee.getPosition(),
                employee.getAccount(),
                employee.getEmail(),
                employee.getEmpStatus()
        );
    }

    public void updateEmployeeDTOToEmployee(UpdateEmployeeDTO dto, Employee employee) {
        if (dto == null || employee == null) {
            return;
        }
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setFatherName(dto.getFatherName());
        employee.setPosition(dto.getPosition());
        employee.setAccount(dto.getAccount());
        employee.setEmail(dto.getEmail());
        employee.setEmpStatus(dto.getStatus());
    }

}
