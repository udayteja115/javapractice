package com.learn.employeemanagement.controller;


import com.learn.employeemanagement.model.Employee;
import com.learn.employeemanagement.repository.EmployeeRepository;
import com.learn.employeemanagement.service.EmployeeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empmanagement/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllMyEmployees(){
        return this.employeeService.getAllEmps();
    }

    @PostMapping("/addemp")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return this.employeeService.addEmployee(employee);
    }
    @PutMapping("/update/{id}")
    public Employee updateEmp(@PathVariable Integer id,@RequestBody Employee employee){
        return this.employeeService.updateEmp(id,employee);
    }
    @DeleteMapping("/delete/{empId}")
    public void deleteEmp(@PathVariable Integer empId){
        this.employeeService.deleteEmp(empId);
    }
    @GetMapping("/emp/{empId}")
    public Employee getEmp(@PathVariable Integer empId){
        return this.employeeService.getSpecificEmp(empId);

    }

}
