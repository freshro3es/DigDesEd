package org.example.mapper;

import org.example.dto.order.OrderEmployeeInTeamDTO;
import org.example.model.Employee;
import org.example.model.EmployeeInTeam;

public class EmployeeInTeamMapper {

    public static OrderEmployeeInTeamDTO toOrderEmployeeInTeamDTO(EmployeeInTeam employeeInTeam) {
        Employee employee = employeeInTeam.getEmployee();
        return new OrderEmployeeInTeamDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getFatherName(),
                employee.getPosition(),
                employee.getAccount(),
                employee.getEmail(),
                employeeInTeam.getRole(),
                employee.getEmpStatus()
        );
    }

//    public List<OrderEmployeeInTeamDTO> toOrderEmployeeList(List<EmployeeInTeam> employeeInTeams) {
//        List<OrderEmployeeInTeamDTO> orderEmployees = new ArrayList<>();
//        for (EmployeeInTeam employeeInTeam : employeeInTeams) {
//            orderEmployees.add(toOrderEmployeeInTeamDTO(employeeInTeam));
//        }
//        return orderEmployees;
//    }

}
