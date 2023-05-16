package org.example.dao;

import org.example.model.Employee;

import java.util.List;

public interface CrudOp<T> {
    void create(T data);

    void update(T data);

    T getById(int id);

    List<T> getAll();

    void deleteById(int id);
}
