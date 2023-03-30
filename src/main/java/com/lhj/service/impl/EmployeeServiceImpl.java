package com.lhj.service.impl;

import com.lhj.dao.EmployeeDao;
import com.lhj.entity.Employee;
import com.lhj.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    @Override
    public List<Employee> find(Employee condition) {
        return employeeDao.find(condition);
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public boolean add(Employee employee) {
        return employeeDao.add(employee) == 1;
    }

    @Override
    public boolean mod(Employee employee) {
        return employeeDao.mod(employee) == 1;
    }

    @Override
    public boolean del(int id) {
        return employeeDao.del(id) == 1;
    }
}
