package org.example.dao;

import org.example.libs.EmpStatus;
import org.example.model.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends DaoOp<Employee> implements CrudOp<Employee> {

    private List<Employee> data= new ArrayList<>();

    public EmployeeDao() {
        super("./Employee.txt", Employee.class);
    }

    //Инициализирует список с работниками в нашем объекте
    //Я хотел сделать статический метод create() для создания
    //employeeDao, но метод read() не статический и без выноса
    //из родительского дженерик класса его таким не сделать
    public void init() throws IOException, ClassNotFoundException {
        data = read();
    }

    @Override
    public void create(Employee employee)  {
        data.add(employee);
        try {
            write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {
        for (int i=0; i< data.size(); i++) {
            if (data.get(i).getId()==employee.getId()) {
                data.set(i, employee);
                try {
                    write(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }

    @Override
    public Employee getById(int id) {
        for (Employee emp : data) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return data;
    }

    @Override
    public void deleteById(int id) {
        for (Employee emp : data) {
            if (emp.getId() == id) {
                emp.setEmpStatus(EmpStatus.DELETED);
                try {
                    write(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }
}
