package org.example.service;

import org.example.dto.create.CreateProjectDTO;
import org.example.dto.order.OrderProjectDTO;
import org.example.dto.search.SearchProjectDTO;
import org.example.dto.update.StatusProjectDTO;
import org.example.dto.update.UpdateProjectDTO;
import org.example.mapper.ProjectMapper;
import org.example.model.Project;
import org.example.model.Team;
import org.example.repository.ProjectRepository;
import org.example.repository.TeamRepository;
import org.example.specification.ProjectSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ProjectMapper projectMapper;

    public List<OrderProjectDTO> findAll() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(projectMapper::toOrderProjectDTO).collect(Collectors.toList());
    }

    public OrderProjectDTO findById(Long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        return projectOptional.map(project -> projectMapper.toOrderProjectDTO(project)).orElse(null);
    }

    public List<OrderProjectDTO> search(SearchProjectDTO searchProjectDTO) {
//        List<Project> projects = projectRepository.search(searchProjectDTO.getSearch());
        List<Project> projects = projectRepository.findAll(
                ProjectSpecification.findByKeywordAndStatus(
                        searchProjectDTO.getSearch(),
                        searchProjectDTO.getStatuses()
                )
        );
        return projects.stream().map(projectMapper::toOrderProjectDTO).collect(Collectors.toList());
    }

    public Project save(CreateProjectDTO createProjectDTO) {
        Project project = projectMapper.toProject(createProjectDTO);
        return projectRepository.save(project);
    }

    public Project update(Long id, UpdateProjectDTO updateProjectDTO) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            projectMapper.updateProjectDTOToProject(updateProjectDTO, project);
            if (updateProjectDTO.getTeamId()!=null) {
                Optional<Team> teamOptional = teamRepository.findById(id);
                teamOptional.ifPresent(project::setTeam);
            }
            return projectRepository.save(project);
        }
        return null;
    }

    public Project delete(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            projectRepository.deleteById(id);
        }
        return project;
    }

    public Project changeStatus(Long id, StatusProjectDTO statusProjectDTO) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project!=null) {
            project.setStatus(statusProjectDTO.getStatus());
            return project;
        }
        return null;
    }


}
