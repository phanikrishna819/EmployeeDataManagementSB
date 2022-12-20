package com.EmployeeData.EmployeeDataManagement.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    public void post(Employee employee) {
        employeeRepository.save(employee);
    }

    public void put(Employee employee) {
        employeeRepository.save(employee);
    }


    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
