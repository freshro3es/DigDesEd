//package org.example.service;
//
////import org.example.dao.EmployeeDAO;
//import org.example.dto.create.CreateTaskDTO;
//import org.example.dto.update.UpdateTaskDTO;
//import org.example.libs.TaskStatus;
//import org.example.model.Employee;
//import org.example.model.Task;
//import org.example.repository.TaskRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TaskService{
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    @Autowired
//    private EmployeeService employeeRepository;
//
//    public Task create(CreateTaskDTO createTaskDTO) {
//        Task task = new Task(
//                null,
//                createTaskDTO.getName(),
//                null,
//                createTaskDTO.getAuthorId(),
//                null,
//                TaskStatus.NEW,
//                createTaskDTO.getCreationDate(),
//                createTaskDTO.getLabourHours(),
//                createTaskDTO.getDeadline(),
//                new Date()
//        );
//        taskRepository.save(task);
//        return task;
//    }
//
//    public Task update(UpdateTaskDTO updateTaskDTO) {
//        if (task.getEmployee() != null) {
//            Employee employee = employeeRepository.findById(task.getEmployee().getId());
//            task.setEmployee(employee);
//        }
//        return taskRepository.update(task);
//    }
//
//    public void delete(Long id) {
//        taskRepository.deleteById(id);
//    }
//
//    public Task findById(Long id) {
//        Optional<Task> taskOptional = taskRepository.findById(id);
//        return taskOptional.orElse(null);
//    }
//
//    public List<Task> findByEmployee(Long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId);
//        if (employee != null) {
//            return taskRepository.findByEmployee(employee);
//        }
//        return Collections.emptyList();
//    }
//
//    public List<Task> findByProject(int projectId) {
//        return taskRepository.findByProject(projectId);
//    }
//
//    public List<Task> findAll() {
//        return taskRepository.findAll();
//    }
//}
