package org.example.config;

import jakarta.persistence.EntityManager;
import org.example.dao.EmployeeDAO;
import org.example.dao.ProjectDAO;
import org.example.dao.TaskDAO;
import org.example.dao.TeamDAO;
import org.example.service.EmployeeService;
import org.example.service.ProjectService;
import org.example.service.TaskService;
import org.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.example")
@PropertySource("classpath:/application.properties")
public class ApplicationConfig {

    @Autowired
    private EntityManager entityManager;



    @Bean
    public EmployeeDAO employeeDao() {
        return new EmployeeDAO(entityManager);
    }

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }

    @Bean
    public TaskDAO taskDao() {
        return new TaskDAO(entityManager);
    }

    @Bean
    public TaskService taskService() {
        return new TaskService();
    }

    @Bean
    public TeamDAO teamDao() {
        return new TeamDAO(entityManager);
    }

    @Bean
    public TeamService teamService() {
        return new TeamService();
    }

    @Bean
    public ProjectDAO projectDao() {
        return new ProjectDAO(entityManager);
    }

    @Bean
    public ProjectService projectService() {
        return new ProjectService();
    }

}
