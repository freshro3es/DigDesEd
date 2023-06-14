package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.dto.create.CreateTaskDTO;
import org.example.dto.order.OrderTaskDTO;
import org.example.dto.order.StackTraceDTO;
import org.example.dto.search.SearchTaskDTO;
import org.example.dto.update.UpdateTaskDTO;
import org.example.libs.TaskStatus;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Task Controller", description = "Task operations")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all tasks", description = "Get all tasks")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public List<OrderTaskDTO> findAll() {
        return taskService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get task by ID", description = "Get task by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Task not found")})
    public OrderTaskDTO findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PostMapping(value = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Search tasks", description = "Search tasks with specific criteria")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public List<OrderTaskDTO> search(@RequestBody SearchTaskDTO searchTaskDTO) {
        return taskService.search(searchTaskDTO);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create task", description = "Create a new task")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public StackTraceDTO<OrderTaskDTO> create(@RequestBody CreateTaskDTO createTaskDTO) {
        OrderTaskDTO orderTaskDTO = taskService.save(createTaskDTO);
        return new StackTraceDTO<>(
                orderTaskDTO,
                orderTaskDTO != null,
                orderTaskDTO != null ? null : "Wrong data"
        );
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update task", description = "Update task by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Task not found")})
    public StackTraceDTO<OrderTaskDTO> update(@PathVariable Long id, @RequestBody UpdateTaskDTO updateTaskDTO) {
        OrderTaskDTO orderTaskDTO = taskService.update(id, updateTaskDTO);
        return new StackTraceDTO<>(
                orderTaskDTO,
                orderTaskDTO != null,
                orderTaskDTO != null ? null : "Wrong data"
        );
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete task", description = "Delete task by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Task not found")})
    public StackTraceDTO<OrderTaskDTO> delete(@PathVariable Long id) {
        OrderTaskDTO orderTaskDTO = taskService.delete(id);
        return new StackTraceDTO<>(
                orderTaskDTO,
                orderTaskDTO != null,
                orderTaskDTO != null ? null : "Wrong id"
        );
    }

    @PutMapping(value = "/{id}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update task status", description = "Update task status by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid status"),
            @ApiResponse(responseCode = "404", description = "Task not found")})
    public StackTraceDTO<Map<String, String>> changeStatus(@PathVariable Long id, @PathVariable TaskStatus status) {
        Map<String, String> data = new HashMap<>() {{
            put("Id", id.toString());
            put("Task status", status.toString());
        }};
        try {
            taskService.changeStatus(id, status);
        } catch (RuntimeException e) {
            return new StackTraceDTO<>(data, false, e.toString());
        }
        return new StackTraceDTO<>(data, true, null);
    }
}
