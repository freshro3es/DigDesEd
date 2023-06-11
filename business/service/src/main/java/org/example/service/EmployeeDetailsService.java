package org.example.service;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService extends UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByAccount(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(
                employee.getAccount(),
                employee.getPassword(),
                employee.isEnabled(),
                employee.isAccountNonExpired(),
                employee.isCredentialsNonExpired(),
                employee.isAccountNonLocked(),
                employee.getAuthorities()
        );
    }
}
