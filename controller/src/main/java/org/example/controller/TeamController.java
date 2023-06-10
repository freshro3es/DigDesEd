package org.example.controller;

import org.example.dto.create.CreateTeamDTO;
import org.example.dto.order.OrderEmployeeInTeamDTO;
import org.example.dto.order.OrderTeamDTO;
import org.example.dto.order.StackTraceDTO;
import org.example.dto.search.SearchTeamDTO;
import org.example.dto.update.AddMemberTeamDTO;
import org.example.dto.update.UpdateTeamDTO;
import org.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderTeamDTO> findAll() {
        return teamService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderTeamDTO findById(@PathVariable Long id) {
        return teamService.findById(id);
    }

    @PostMapping(value = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderTeamDTO> search(@RequestBody SearchTeamDTO searchTeamDTO) {
        return teamService.search(searchTeamDTO);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public StackTraceDTO<OrderTeamDTO> createTeam(@RequestBody CreateTeamDTO createTeamDTO) {
        OrderTeamDTO orderTeamDTO = teamService.save(createTeamDTO);
        return new StackTraceDTO<>(
                orderTeamDTO,
                orderTeamDTO != null,
                orderTeamDTO != null ? null : "Wrong data"
        );
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public StackTraceDTO<OrderTeamDTO> updateTeam(@PathVariable Long id, @RequestBody UpdateTeamDTO updateTeamDTO) {
        OrderTeamDTO orderTeamDTO = teamService.update(id, updateTeamDTO);
        return new StackTraceDTO<>(
                orderTeamDTO,
                orderTeamDTO != null,
                orderTeamDTO != null ? null : "Wrong data"
        );
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public StackTraceDTO<OrderTeamDTO> deleteTeam(@PathVariable Long id) {
        OrderTeamDTO orderTeamDTO = teamService.delete(id);
        return new StackTraceDTO<>(
                orderTeamDTO,
                orderTeamDTO != null,
                orderTeamDTO != null ? null : "Wrong data"
        );
    }



    @GetMapping(value = "/{teamId}/members", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderEmployeeInTeamDTO> getTeamMembers(@PathVariable Long teamId) {
        return teamService.getTeamMembers(teamId);
    }

    @PostMapping(value = "/{teamId}/members", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addTeamMember(@PathVariable Long teamId, @RequestBody AddMemberTeamDTO addMemberTeamDTO) {
        teamService.addTeamMember(teamId, addMemberTeamDTO);
    }

    @DeleteMapping(value = "/{teamId}/members/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeamMember(@PathVariable Long teamId, @PathVariable Long employeeId) {
        teamService.deleteTeamMember(teamId, employeeId);
    }

}
