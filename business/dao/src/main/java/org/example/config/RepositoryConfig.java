package org.example.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
//import org.example.dao.EmployeeDAO;
//import org.example.dao.ProjectDAO;
//import org.example.dao.TaskDAO;
//import org.example.dao.TeamDAO;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"org.example.repository"})
@PropertySource("file:../../../../view/src/main/resources/application.properties")
public class RepositoryConfig {

    @PersistenceContext
    private EntityManager entityManager;

//    @Bean
//    public EmployeeDAO employeeDao() {
//        return new EmployeeDAO(entityManager);
//    }

//    @Bean
//    public TaskDAO taskDao() {
//        return new TaskDAO(entityManager);
//    }
//
//    @Bean
//    public TeamDAO teamDao() {
//        return new TeamDAO(entityManager);
//    }
//
//    @Bean
//    public ProjectDAO projectDao() {
//        return new ProjectDAO(entityManager);
//    }

}
