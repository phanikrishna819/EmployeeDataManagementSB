package com.EmployeeData.EmployeeDataManagement.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {


    List<Employee> tax = new ArrayList<>(Arrays.asList());


    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @RequestMapping(method = RequestMethod.GET, value = "EmployeeData/Employees")
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "EmployeeData/Employees")
    public void getPostEmployees(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "EmployeeData/Employees/{EmployeeID}")
    public void getPutEmployee(@RequestBody Employee employee, @PathVariable int EmployeeID) {
        employeeRepository.save(employee);
    }

    @DeleteMapping("EmployeeData/Employees/{EmployeeID}")
    public void Delete(@RequestBody Employee employee, @PathVariable int EmployeeID) {
        employeeRepository.delete(employee);
    }

}
