package com.lhj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhj.entity.Department;
import com.lhj.entity.Employee;
import com.lhj.service.DepartmentService;
import com.lhj.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepartmentService departmentService;

    @RequestMapping("search")
    public ModelAndView search(Employee condition, @RequestParam(defaultValue = "1") int pageNo) {
        ModelAndView mv = new ModelAndView("emp/list");
        PageHelper.startPage(pageNo, 3);
        List<Employee> employeeList = employeeService.find(condition);
        PageInfo pageInfo = new PageInfo(employeeList);
        List<Department> departmentList = departmentService.findAll();

        mv.addObject("empList", employeeList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("depList", departmentList);
        mv.addObject("c", condition);
        return mv;
    }

    @GetMapping("add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("emp/add");
        List<Department> departmentList = departmentService.findAll();
        mv.addObject("depList", departmentList);
        return mv;
    }

    @PostMapping("add")
    public String add(Employee employee) {
        if (employeeService.add(employee)) {
            return "redirect:search";
        } else {
            return "redirect:add";
        }
    }

    @GetMapping("mod")
    public ModelAndView mod(int id) {
        ModelAndView mv = new ModelAndView("emp/mod");
        Employee emp = employeeService.findById(id);
        mv.addObject("emp", emp);
        List<Department> departmentList = departmentService.findAll();
        mv.addObject("depList", departmentList);
        return mv;
    }

    @PostMapping("mod")
    public String mod(Employee employee) {
        if (employeeService.mod(employee)) {
            return "redirect:search";
        } else {
            return "redirect:mod";
        }
    }

    @GetMapping("del")
    public String del(int id) {
        employeeService.del(id);
        return "redirect:search";
    }
}
