package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Team Controller", description = "CRUD operations for Team entity")
public class TeamController {

    @Autowired
    private TeamService teamService;


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all teams", description = "Get all teams")
    @ApiResponse(description = "Successful operation", responseCode = "200")
    public List<OrderTeamDTO> findAll() {
        return teamService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get team by ID", description = "Get team by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Team not found")})
    public OrderTeamDTO findById(@PathVariable Long id) {
        return teamService.findById(id);
    }

    @PostMapping(value = "/filter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Search teams", description = "Search teams with specific criteria")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public List<OrderTeamDTO> search(@RequestBody SearchTeamDTO searchTeamDTO) {
        return teamService.search(searchTeamDTO);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new team", description = "Create a new team")
    @ApiResponse(responseCode = "200", description = "Successful operation")
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
    @Operation(summary = "Update a team by ID", description = "Update a team by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Team not found")})
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
    @Operation(summary = "Delete a team by ID", description = "Delete a team by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Team not found")})
    public StackTraceDTO<OrderTeamDTO> deleteTeam(@PathVariable Long id) {
        OrderTeamDTO orderTeamDTO = teamService.delete(id);
        return new StackTraceDTO<>(
                orderTeamDTO,
                orderTeamDTO != null,
                orderTeamDTO != null ? null : "Wrong data"
        );
    }

    @GetMapping(value = "/{teamId}/members", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all team members by team ID", description = "Get all team members by team ID")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public List<OrderEmployeeInTeamDTO> getTeamMembers(@PathVariable Long teamId) {
        return teamService.getTeamMembers(teamId);
    }

    @PostMapping(value = "/{teamId}/members", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a team member to a team by team ID", description = "Add a team member to a team by team ID")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public void addTeamMember(@PathVariable Long teamId, @RequestBody AddMemberTeamDTO addMemberTeamDTO) {
        teamService.addTeamMember(teamId, addMemberTeamDTO);
    }

    @DeleteMapping(value = "/{teamId}/members/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete a team member from a team by team ID and employee ID", description = "Delete a team member from a team by team ID and employee ID")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public void deleteTeamMember(@PathVariable Long teamId, @PathVariable Long employeeId) {
        teamService.deleteTeamMember(teamId, employeeId);
    }
}
