package org.example.controller;

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
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderProjectDTO> findAll() {
        return projectService.findAll();
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderProjectDTO findById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @PostMapping(value = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderProjectDTO> search(@RequestBody SearchProjectDTO searchProjectDTO) {
        return projectService.search(searchProjectDTO);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
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
