package org.example.service;

import org.example.dto.create.CreateTaskDTO;
import org.example.dto.order.OrderTaskDTO;
import org.example.dto.search.SearchTaskDTO;
import org.example.dto.update.UpdateTaskDTO;
import org.example.libs.TaskStatus;
import org.example.mapper.TaskMapper;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.example.specification.TaskSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;


    public List<OrderTaskDTO> findAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(taskMapper::toOrderTaskDTO).collect(Collectors.toList());
    }

    public OrderTaskDTO findById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.map(task -> taskMapper.toOrderTaskDTO(task)).orElse(null);
    }

    public List<OrderTaskDTO> search(SearchTaskDTO searchTaskDTO) {
        List<Task> tasks = taskRepository.findAll(TaskSpecification.findWithFilter(searchTaskDTO));
        return tasks.stream().map(taskMapper::toOrderTaskDTO).collect(Collectors.toList());
    }

    public OrderTaskDTO save(CreateTaskDTO createTaskDTO) {
        Task task = taskMapper.toTask(createTaskDTO);
        return taskMapper.toOrderTaskDTO(taskRepository.save(task));
    }

    public OrderTaskDTO update(Long id, UpdateTaskDTO updateTaskDTO) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            taskMapper.updateTaskDTOToTask(updateTaskDTO, task);
            return taskMapper.toOrderTaskDTO(taskRepository.save(task));
        }
        return null;
    }

    public OrderTaskDTO delete(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            taskRepository.deleteById(id);
        }
        return taskMapper.toOrderTaskDTO(task);
    }

    public OrderTaskDTO changeStatus(Long id, TaskStatus status) throws RuntimeException {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            throw new RuntimeException("Project with id = '" + id + "' not found");
        }

        TaskStatus currentStatus = task.getStatus();
        if (currentStatus.compareTo(status) >= 0) {
            throw new RuntimeException("Task status '" + task.getStatus() + "' cannot be changed to status '" + status + "'");
        }

        switch (status) {
            case IN_PROGRESS, COMPLETED, CLOSED -> {
                if (status.ordinal() != (currentStatus.ordinal() + 1)) {
                    throw new RuntimeException("Task status '" + task.getStatus() + "' cannot be changed to status '" + status + "'");
                }
            }
        }

        task.setStatus(status);
        taskRepository.save(task);
        return taskMapper.toOrderTaskDTO(task);
    }
}
