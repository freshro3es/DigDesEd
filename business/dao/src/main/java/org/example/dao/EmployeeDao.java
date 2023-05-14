package org.example.dao;

import org.example.model.Employee;

import java.util.List;

public class EmployeeDao extends DaoOp<Employee> {
    public EmployeeDao() {
        super("Employee.txt", Employee.class);
    }


    //Это пока заглушки для методов, допишу позже
    //-------------------------------------------
    public void create(Employee employee) {
        //add(employee);
    }

    public void update(Employee employee) {
        //updateItem(employee);
    }

    public Employee getById(int id) {
        return null; //getItemById(id);
    }

    public List<Employee> getAll() {
        return null; //getAllItems();
    }

    public void deleteById(int id) {
        //deleteItemById(id);
    }
    //-------------------------------------------
}
