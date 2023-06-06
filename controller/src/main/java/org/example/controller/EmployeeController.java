package org.example.controller;

import org.example.dto.create.CreateEmployeeDTO;
import org.example.dto.order.OrderEmployeeDTO;
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
        System.out.println(searchEmployeeDTO.getSearch());
        return employeeService.search(searchEmployeeDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderEmployeeDTO getEmployeeById(@PathVariable Long id) {
        System.out.println("Controller works");
        return employeeService.findById(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        employeeService.save(createEmployeeDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeDTO updateEmployeeDTO) {
        employeeService.update(id, updateEmployeeDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
