package org.example.config;

import org.example.dao.EmployeeDAO;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.example")
public class ApplicationConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public EmployeeDAO employeeDao() {
        return new EmployeeDAO(dataSource);
    }

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }
}
