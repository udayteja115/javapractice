package com.learn.employeemanagement.service;

import com.learn.employeemanagement.model.Employee;
import com.learn.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //add employee data

    public Employee addEmployee(Employee employee){

        this.employeeRepository.save(employee);

        return employee;
    }

    //get employee data

    public List<Employee> getAllEmps(){
        return this.employeeRepository.findAll();

    }

    public Employee updateEmp(Integer id,Employee newEmpData){
        Employee oldEmpData= this.employeeRepository.findById(id).get();

        oldEmpData.setFirstName(newEmpData.getFirstName());
        oldEmpData.setLastName(newEmpData.getLastName());
        oldEmpData.setNoOfYearsOfExperience(newEmpData.getNoOfYearsOfExperience());
        oldEmpData.setSalary(newEmpData.getSalary());

        this.employeeRepository.save(oldEmpData);

        return oldEmpData;


    }

    //delete empl data
    public void deleteEmp(Integer id){
        this.employeeRepository.deleteById(id);

    }

    public Employee getSpecificEmp(Integer empId){
        Employee selectedEmp= this.employeeRepository.findById(empId).get();
        return selectedEmp;
    }


}
