package org.example.controller;

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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderEmployeeDTO> findAll() {
        return employeeService.findAll();
    }

    @PostMapping(value = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderEmployeeDTO> search(@RequestBody SearchEmployeeDTO searchEmployeeDTO) {
        return employeeService.search(searchEmployeeDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderEmployeeDTO getEmployeeById(@PathVariable Long id) {
        System.out.println("Controller works");
        return employeeService.findById(id);
    }

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
