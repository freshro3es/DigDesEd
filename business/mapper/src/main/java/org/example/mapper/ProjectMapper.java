package org.example.mapper;

import org.example.dto.create.CreateProjectDTO;
import org.example.dto.order.OrderProjectDTO;
import org.example.dto.update.UpdateProjectDTO;
import org.example.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public Project toProject(CreateProjectDTO dto) {
        if (dto == null) {
            return null;
        }
        Project project = new Project();
        project.setName(dto.getName());
        return project;
    }

    public OrderProjectDTO toOrderProjectDTO(Project project) {
        if (project == null) {
            return null;
        }
        return new OrderProjectDTO(
                project.getName(),
                project.getDescription(),
                project.getStatus(),
                project.getTeam().getName()
        );
    }

    public void updateProjectDTOToProject(UpdateProjectDTO dto, Project project) {
        if (dto == null || project == null) {
            return;
        }
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
    }
}
