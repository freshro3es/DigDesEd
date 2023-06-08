package org.example.service;

import org.example.dto.create.CreateTeamDTO;
import org.example.dto.order.OrderEmployeeInTeamDTO;
import org.example.dto.order.OrderTeamDTO;
import org.example.dto.search.SearchTeamDTO;
import org.example.dto.update.AddMemberTeamDTO;
import org.example.dto.update.UpdateTeamDTO;
import org.example.mapper.EmployeeInTeamMapper;
import org.example.mapper.EmployeeMapper;
import org.example.mapper.TeamMapper;
import org.example.model.Employee;
import org.example.model.EmployeeInTeam;
import org.example.model.Team;
import org.example.repository.EmployeeInTeamRepository;
import org.example.repository.EmployeeRepository;
import org.example.repository.TeamRepository;
import org.example.specification.EmployeeInTeamSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private EmployeeInTeamRepository employeeInTeamRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TeamMapper teamMapper;

    public List<OrderTeamDTO> findAll() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(teamMapper::toOrderTeamDTO).collect(Collectors.toList());
    }

    public OrderTeamDTO findById(Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        return teamOptional.map(team -> teamMapper.toOrderTeamDTO(team)).orElse(null);
    }

    public  List<OrderTeamDTO> search(SearchTeamDTO searchTeamDTO) {
        List<Team> teams = teamRepository.search(searchTeamDTO.getSearch());
        return teams.stream().map(teamMapper::toOrderTeamDTO).collect(Collectors.toList());
    }

    public Team save(CreateTeamDTO createTeamDTO) {
        Team team = teamMapper.toTeam(createTeamDTO);
        return teamRepository.save(team);
    }

    public Team update(Long id, UpdateTeamDTO updateTeamDTO) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            teamMapper.updateTeamDTOtoTeam(updateTeamDTO, team);
            return teamRepository.save(team);
        }
        return null;
    }

    public Team delete(Long id) {
        Team team = teamRepository.findById(id).orElse(null);
        teamRepository.deleteById(id);
        return team;
    }

    public List<OrderEmployeeInTeamDTO> getTeamMembers(Long teamId) {
//        List<Employee> employees = teamRepository.getEmployeesInTeam(teamId);

        List<EmployeeInTeam> employeesInTeam = employeeInTeamRepository.findAll(
                EmployeeInTeamSpecification.findAllByTeamId(teamRepository.findById(teamId).get())
        );
        return employeesInTeam.stream().map(EmployeeInTeamMapper::toOrderEmployeeInTeamDTO).collect(Collectors.toList());
    }

    public EmployeeInTeam addTeamMember(Long teamId, AddMemberTeamDTO addMemberTeamDTO) {
        Optional<Employee> employeeOptional = employeeRepository.findById(addMemberTeamDTO.getEmployeeId());
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (employeeOptional.isPresent() & teamOptional.isPresent() & addMemberTeamDTO.getRole()!=null) {
            EmployeeInTeam employeeInTeam = new EmployeeInTeam();

            employeeInTeam.setEmployee(employeeOptional.get());
            employeeInTeam.setTeam(teamOptional.get());
            employeeInTeam.setRole(addMemberTeamDTO.getRole());

            return employeeInTeamRepository.save(employeeInTeam);
        }
        return null;
    }

    @Transactional(readOnly = false)
    public void deleteTeamMember(Long teamId, Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (employeeOptional.isPresent() & teamOptional.isPresent()) {
            long rows = employeeInTeamRepository.delete(
                    EmployeeInTeamSpecification.findByTeamAndEmployeeId(
                            teamOptional.get(),
                            employeeOptional.get()
                    )
            );
            System.out.println("Rows in 'employee_in_team' deleted: " + rows);
        }
    }
}

