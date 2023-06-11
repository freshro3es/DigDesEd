package org.example.config;


//import jakarta.servlet.Filter;
//import lombok.RequiredArgsConstructor;
//import org.example.service.EmployeeDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final JwtAuthenticationFilter jwtAuthFilter;
//    private final AuthenticationProvider authenticationProvider;
//
//
//    @Bean
//    EmployeeDetailsService employeeDetailsService(DataSource dataSource) {
//        return new EmployeeDetailsService();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain( HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(
//                        authorizeHttpRequests -> authorizeHttpRequests
////                                .requestMatchers("/**").permitAll()
//                                .anyRequest().authenticated()
//                )
////                .sessionManagement(
////                        sessionManagement -> sessionManagement
////                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                )
////                .authenticationProvider(authenticationProvider)
//                .httpBasic(Customizer.withDefaults());
////                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//}
