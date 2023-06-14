package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"org.example.dao", "org.example.repository"})
@EnableJpaRepositories(basePackages = {"org.example.repository"})
//@PropertySource("file:../../../../view/src/main/resources/application.properties")
public class RepositoryConfig {

}
