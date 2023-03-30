package com.lhj.service.impl;

import com.lhj.dao.DepartmentDao;
import com.lhj.dao.EmployeeDao;
import com.lhj.entity.Department;
import com.lhj.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    DepartmentDao departmentDao;
    @Resource
    EmployeeDao employeeDao;

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public List<Department> find(Department condition) {
        return departmentDao.find(condition);
    }

    @Override
    public Department findById(int id) {
        return departmentDao.findById(id);
    }

    @Override
    public boolean add(Department department) {
        return departmentDao.add(department) == 1;
    }

    @Override
    public boolean mod(Department department) {
        return departmentDao.mod(department) == 1;
    }

    @Override
    public boolean del(int id) {
        if (departmentDao.del(id) == 1) {
            employeeDao.modByDep(id);
            return true;
        }
        return false;
    }
}
