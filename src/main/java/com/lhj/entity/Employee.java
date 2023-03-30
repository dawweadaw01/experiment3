package com.lhj.entity;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private Integer number;
    private String name;
    private String gender;
    private Integer age;
    private Department dep;
}
