package org.example.controller;

import org.example.dto.create.CreateProjectDTO;
import org.example.dto.create.CreateTeamDTO;
import org.example.dto.order.OrderProjectDTO;
import org.example.dto.order.OrderTeamDTO;
import org.example.dto.search.SearchProjectDTO;
import org.example.dto.update.UpdateProjectDTO;
import org.example.dto.update.UpdateTeamDTO;
import org.example.service.ProjectService;
import org.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

//    @Autowired
//    private ProjectService projectService;
//
//    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<OrderProjectDTO> findAll() {
//        return projectService.findAll();
//    }
//
//
//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public OrderProjectDTO findById(@PathVariable Long id) {
//        return projectService.findById(id);
//    }
//
//    @PostMapping(value = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<OrderProjectDTO> search(@RequestBody SearchProjectDTO searchProjectDTO) {
//        return projectService.search(searchProjectDTO);
//    }
//
//    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createTeam(@RequestBody CreateProjectDTO createProjectDTO) {
//        projectService.create(createProjectDTO);
//    }
//
//    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public void updateTeam(@PathVariable Long id, @RequestBody UpdateProjectDTO updateProjectDTO) {
//        projectService.update(id, updateProjectDTO);
//    }
//
//    @PostMapping(value = "/{id}/status", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public void changeStatusTeam(@PathVariable Long id, @RequestBody StatusProjectDTO statusProjectDTO) {
//        projectService.changeStatus(id, statusProjectDTO);
//    }
}
