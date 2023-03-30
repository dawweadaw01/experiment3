package com.lhj.service;

import com.lhj.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> find(Employee condition);

    Employee findById(int id);

    boolean add(Employee employee);

    boolean mod(Employee employee);

    boolean del(int id);
}
