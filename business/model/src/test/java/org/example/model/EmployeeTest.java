//package org.example.model;
//
//import org.example.config.ModelConfig;
//import org.example.libs.EmpStatus;
//import org.example.repository.EmployeeRepository;
//import org.junit.jupiter.api.Test;
//
//import org.junit.jupiter.api.Assertions;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//
//import java.util.List;
//
//@SpringJUnitConfig(ModelConfig.class)
//@DataJpaTest
//class EmployeeTest {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    @Test
//    void shouldSaveEmployee() {
//        Employee emp = new Employee();
//        emp.setFirstName("Ivan");
//        emp.setLastName("Ivanov");
//        emp.setPosition("Developer");
//        emp.setAccount("ivan.ivanov");
//        emp.setPassword("qwerty123");
//        emp.setEmpStatus(EmpStatus.ACTIVE);
//        Employee savedEmp = employeeRepository.save(emp);
//        Assertions.assertNotNull(savedEmp.getId());
//    }
//
//    @Test
//    void shouldFindEmployeeByAccount() {
//        Employee emp = new Employee();
//        emp.setFirstName("Ivan");
//        emp.setLastName("Ivanov");
//        emp.setPosition("Developer");
//        emp.setAccount("ivan.ivanov");
//        emp.setPassword("qwerty123");
//        emp.setEmpStatus(EmpStatus.ACTIVE);
//        employeeRepository.save(emp);
//        Employee foundEmp = employeeRepository.findByAccount("ivan.ivanov").orElse(null);
//        Assertions.assertNotNull(foundEmp);
//        Assertions.assertEquals(emp.getFirstName(), foundEmp.getFirstName());
//        Assertions.assertEquals(emp.getLastName(), foundEmp.getLastName());
//        Assertions.assertEquals(emp.getPosition(), foundEmp.getPosition());
//        Assertions.assertEquals(emp.getAccount(), foundEmp.getAccount());
//        Assertions.assertEquals(emp.getPassword(), foundEmp.getPassword());
//        Assertions.assertEquals(emp.getEmpStatus(), foundEmp.getEmpStatus());
//    }
//
//    @Test
//    void shouldFindEmployeesByPosition() {
//        Employee emp1 = new Employee();
//        emp1.setFirstName("Ivan");
//        emp1.setLastName("Ivanov");
//        emp1.setPosition("Developer");
//        emp1.setAccount("ivan.ivanov");
//        emp1.setPassword("qwerty123");
//        emp1.setEmpStatus(EmpStatus.ACTIVE);
//        employeeRepository.save(emp1);
//
//        Employee emp2 = new Employee();
//        emp2.setFirstName("Petr");
//        emp2.setLastName("Petrov");
//        emp2.setPosition("QA Engineer");
//        emp2.setAccount("petr.petrov");
//        emp2.setPassword("asdfgh123");
//        emp2.setEmpStatus(EmpStatus.ACTIVE);
//        employeeRepository.save(emp2);
//
//        List<Employee> foundEmps = employeeRepository.findByPosition("Developer");
//        Assertions.assertEquals(1, foundEmps.size());
//        Assertions.assertEquals(emp1.getFirstName(), foundEmps.get(0).getFirstName());
//        Assertions.assertEquals(emp1.getLastName(), foundEmps.get(0).getLastName());
//        Assertions.assertEquals(emp1.getPosition(), foundEmps.get(0).getPosition());
//        Assertions.assertEquals(emp1.getAccount(), foundEmps.get(0).getAccount());
//        Assertions.assertEquals(emp1.getPassword(), foundEmps.get(0).getPassword());
//        Assertions.assertEquals(emp1.getEmpStatus(), foundEmps.get(0).getEmpStatus());
//    }
//
//}