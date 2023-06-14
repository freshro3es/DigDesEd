package org.example.mapper;

import org.example.dto.create.CreateTaskDTO;
import org.example.dto.order.OrderTaskDTO;
import org.example.dto.update.UpdateTaskDTO;
import org.example.model.Task;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskMapper {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Task toTask(CreateTaskDTO dto) {
        if (dto == null) {
            return null;
        }
        Task task = new Task();
        task.setName(dto.getName());
        task.setAuthorId(dto.getAuthorId());
        task.setStatus(dto.getStatus());
        task.setCreationDate(dto.getCreationDate());
        task.setLabourHours(dto.getLabourHours());
        task.setDeadline(dto.getDeadline());
        task.setUpdateDate(task.getCreationDate());
        return task;
    }

    public OrderTaskDTO toOrderTaskDTO(Task task) {
        if (task == null) {
            return null;
        }
        return new OrderTaskDTO(
                task.getId(),
                task.getEmployee() != null ? task.getEmployee().getId() : null,
                task.getProjectId(),
                task.getName(),
                task.getDescription(),
                task.getAuthorId(),
                task.getStatus(),
                task.getCreationDate(),
                task.getLabourHours(),
                task.getDeadline(),
                task.getUpdateDate()
        );
    }

    public void updateTaskDTOToTask(UpdateTaskDTO dto, Task task) {
        if (dto == null || task == null) {
            return;
        }
        employeeRepository.findById(dto.getEmployeeId()).ifPresent(task::setEmployee);
        task.setProjectId(dto.getProjectId());
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setLabourHours(dto.getLabourHours());
        task.setDeadline(dto.getDeadline());
        task.setUpdateDate(new Date());
    }

}
