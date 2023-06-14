package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.dto.create.CreateEmployeeDTO;
import org.example.dto.order.OrderEmployeeDTO;
import org.example.dto.order.StackTraceDTO;
import org.example.dto.search.SearchEmployeeDTO;
import org.example.dto.update.UpdateEmployeeDTO;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employee Controller", description = "APIs for managing employee data")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Operation(summary = "Get all employees", description = "Get a list of all employees.")
    @ApiResponse(responseCode = "200", description = "List of employees retrieved successfully")
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderEmployeeDTO> findAll() {
        return employeeService.findAll();
    }

    @Operation(summary = "Filter employees", description = "Filter employees based on the provided search criteria.")
    @ApiResponse(responseCode = "200", description = "List of filtered employees retrieved successfully")
    @PostMapping(value = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderEmployeeDTO> search(@RequestBody SearchEmployeeDTO searchEmployeeDTO) {
        return employeeService.search(searchEmployeeDTO);
    }

    @Operation(summary = "Get employee by ID", description = "Get an employee by ID.")
    @ApiResponse(responseCode = "200", description = "Employee retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderEmployeeDTO getEmployeeById(@PathVariable Long id) {
        System.out.println("Controller works");
        return employeeService.findById(id);
    }

    @Operation(summary = "Create new employee", description = "Create a new employee.")
    @ApiResponse(responseCode = "201", description = "Employee created successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public StackTraceDTO<OrderEmployeeDTO> createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        OrderEmployeeDTO orderEmployeeDTO = employeeService.save(createEmployeeDTO);
        return new StackTraceDTO<>(
                orderEmployeeDTO,
                orderEmployeeDTO != null,
                orderEmployeeDTO != null ? null : "Wrong data"
        );
    }

    @Operation(summary = "Update employee by ID", description = "Update an existing employee by ID.")
    @ApiResponse(responseCode = "200", description = "Employee updated successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public StackTraceDTO<OrderEmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeDTO updateEmployeeDTO) {
        OrderEmployeeDTO orderEmployeeDTO = employeeService.update(id, updateEmployeeDTO);
        return new StackTraceDTO<>(
                orderEmployeeDTO,
                orderEmployeeDTO != null,
                orderEmployeeDTO != null ? null : "Wrong data"
        );
    }

    @Operation(summary = "Delete employee by ID", description = "Delete an existing employee by ID.")
    @ApiResponse(responseCode = "200", description = "Employee deleted successfully")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public StackTraceDTO<OrderEmployeeDTO> deleteEmployee(@PathVariable Long id) {
        OrderEmployeeDTO orderEmployeeDTO = employeeService.delete(id);
        return new StackTraceDTO<>(
                orderEmployeeDTO,
                orderEmployeeDTO != null,
                orderEmployeeDTO != null ? null : "Wrong id"
        );
    }
}
