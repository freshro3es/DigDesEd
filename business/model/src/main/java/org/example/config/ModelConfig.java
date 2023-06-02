package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"org.example.model"})
@PropertySource("file:../../../../view/src/main/resources/application.properties")
public class ModelConfig {

}