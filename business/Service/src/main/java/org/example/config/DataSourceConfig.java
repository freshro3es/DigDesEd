package org.example.config;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.*;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//@ComponentScan(basePackages = "org.example")
//@PropertySource("classpath:/application.properties")
//public class DataSourceConfig {
//
//
//    @Value("${datasource.url}")
//    private String url;
//
//    @Value("${datasource.username}")
//    private String username;
//
//    @Value("${datasource.password}")
//    private String password;
//
//    @Value("${datasource.driver-class-name}")
//    private String driver;
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username );
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//}
