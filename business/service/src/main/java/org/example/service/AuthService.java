package org.example.service;

//import lombok.RequiredArgsConstructor;
//import org.example.dto.auth.AuthenticationRequest;
//import org.example.dto.auth.AuthenticationResponse;
//import org.example.dto.create.CreateEmployeeDTO;
//import org.example.libs.UserRole;
//import org.example.model.Employee;
//import org.example.repository.EmployeeRepository;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//
//    private final EmployeeRepository employeeRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    private final JwtService jwtService;
//
//    private final AuthenticationManager authenticationManager;
//    public AuthenticationResponse register(CreateEmployeeDTO dto) {
//        Employee employee = new Employee();
//        employee.setFirstName(dto.getFirstname());
//        employee.setLastName(dto.getLastname());
//        employee.setEmail(dto.getEmail());
//        employee.setPassword(passwordEncoder.encode(dto.getPassword()));
//        employee.setRole(UserRole.USER);
//        employee.setEmpStatus(dto.getStatus());
//        employeeRepository.save(employee);
//        String jwtToken = jwtService.generateToken(employee);
//        return new AuthenticationResponse(jwtToken);
//    }
//
//    public AuthenticationResponse authenticate (AuthenticationRequest authenticationRequest) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        authenticationRequest.getEmail(),
//                        authenticationRequest.getPassword()
//                )
//        );
//        Employee employee = employeeRepository
//                .findByEmail(authenticationRequest.getEmail()).orElseThrow();
//        String jwtToken = jwtService.generateToken(employee);
//        return new AuthenticationResponse(jwtToken);
//    }
//}
