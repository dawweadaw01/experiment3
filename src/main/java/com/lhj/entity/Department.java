package com.lhj.entity;

import lombok.Data;

import java.util.List;
@Data
public class Department {
    private Integer id;
    private String name;
    private Integer number;
    private List<Employee> employeeList;
}
