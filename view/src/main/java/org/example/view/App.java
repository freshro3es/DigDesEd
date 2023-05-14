package org.example.view;

import org.example.dao.EmployeeDao;
import org.example.model.EmpStat;
import org.example.model.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Пока что в этом классе проверяю, работает ли функциональность, которую я пишу
public class App {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

        // Создание Java-объекта, который нужно сериализовать
        String firstName = "Marcello";
        String lastName = "Makaroni";
        String fatherName = null;
        String position = "SEO";
        String account = "freshwater";
        String email = "marcellomakaroni@gmail.com";
        EmpStat status = EmpStat.ACTIVE;
        Employee employee = new Employee(firstName, lastName, fatherName, position, account, email, status);

        List<Employee> data= new ArrayList<>();
        data.add(employee);

        EmployeeDao empDao = new EmployeeDao();
        try {
            empDao.write(data);
            System.out.println("Employee serialized");
            List<Employee> read = empDao.read();
            System.out.println("Employee deserialized");
            for (Employee i :read) {
                System.out.println(i);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
