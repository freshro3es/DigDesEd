package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.dto.create.CreateProjectDTO;
import org.example.dto.order.OrderProjectDTO;
import org.example.dto.order.StackTraceDTO;
import org.example.dto.search.SearchProjectDTO;
import org.example.dto.update.UpdateProjectDTO;
import org.example.libs.ProjStatus;
import org.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projects")
@Tag(name = "Project Controller", description = "Project operations")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all projects", description = "Get all projects")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public List<OrderProjectDTO> findAll() {
        return projectService.findAll();
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get project by ID", description = "Get project by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Project not found")})
    public OrderProjectDTO findById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @PostMapping(value = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Search projects", description = "Search projects with specific criteria")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public List<OrderProjectDTO> search(@RequestBody SearchProjectDTO searchProjectDTO) {
        return projectService.search(searchProjectDTO);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create project", description = "Create a new project")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public StackTraceDTO<OrderProjectDTO> create(@RequestBody CreateProjectDTO createProjectDTO) {
        OrderProjectDTO orderProjectDTO = projectService.save(createProjectDTO);
        return new StackTraceDTO<>(
                orderProjectDTO,
                orderProjectDTO != null,
                orderProjectDTO != null ? null : "Wrong data"
        );

    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update project", description = "Update project by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Project not found")})
    public StackTraceDTO<OrderProjectDTO> update(@PathVariable Long id, @RequestBody UpdateProjectDTO updateProjectDTO) {
        OrderProjectDTO orderProjectDTO = projectService.update(id, updateProjectDTO);
        return new StackTraceDTO<>(
                orderProjectDTO,
                orderProjectDTO != null,
                orderProjectDTO != null ? null : "Wrong data"
        );
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete project", description = "Delete project by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Project not found")})
    public StackTraceDTO<OrderProjectDTO> delete(@PathVariable Long id) {
        OrderProjectDTO orderProjectDTO = projectService.delete(id);
        return new StackTraceDTO<>(
                orderProjectDTO,
                orderProjectDTO != null,
                orderProjectDTO != null ? null : "Wrong id"
        );
    }

    @PutMapping(value = "/{id}/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update project status", description = "Update project status by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid status"),
            @ApiResponse(responseCode = "404", description = "Project not found")})
    public StackTraceDTO<Map<String, String>> changeStatus(@PathVariable Long id, @PathVariable ProjStatus status) {
        Map<String, String> data = new HashMap<>() {{
            put("Id", id.toString());
            put("Project status", status.toString());
        }};
        try {
            projectService.changeStatus(id, status);
        } catch (RuntimeException e) {
            return new StackTraceDTO<>(data, false, e.toString());
        }
        return new StackTraceDTO<>(data, true, null);
    }
}
