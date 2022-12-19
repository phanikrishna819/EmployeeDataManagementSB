package com.EmployeeData.EmployeeDataManagement.entity.Tax;


import com.EmployeeData.EmployeeDataManagement.entity.Employee;
import com.EmployeeData.EmployeeDataManagement.entity.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TaxService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    List<Tax> tests = new ArrayList<>(Arrays.asList(new Tax()));

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private List<Employee> employees;

    private int AnnualSalary;

    private String ID;
    private double tax;

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public List<Employee> getSalary() {
        return employees;
    }

    public void setSalary(List<Employee> employees) {
        this.employees = employees;
    }

    public int getAnnualSalary() {
        return AnnualSalary;
    }

    public void setAnnualSalary(int annualSalary) {
        AnnualSalary = annualSalary;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Tax> getSingleTax(int EmployeeID) {
        ID= String.valueOf(EmployeeID);
        Optional<Employee> employee = employeeRepository.findById(ID);
        AnnualSalary = employee.get().getMonthlySalary();
        AnnualSalary = AnnualSalary*12;
        if(AnnualSalary<=200000)
        {
            return new ArrayList<>(Arrays.asList(new Tax(getAnnualSalary(), getID(), 0)));
        }
        else if(AnnualSalary<=300000)
        {
            tax = (AnnualSalary-200000)*0.1;
            return new ArrayList<>(Arrays.asList(new Tax(getAnnualSalary(), getID(),getTax())));
        }
        else if(AnnualSalary<=500000) {
            tax = (AnnualSalary - 300000)*0.2 + (100000*0.1);
            return new ArrayList<>(Arrays.asList(new Tax(getAnnualSalary(), getID(), getTax())));
        }
        else if(AnnualSalary<=1000000)
        {
            tax = ((AnnualSalary-500000)*0.3)+(200000*0.2)+(100000*0.1);
            return new ArrayList<>(Arrays.asList(new Tax(getAnnualSalary(), getID(), getTax())));
        }
        else
        {
            tax = ((AnnualSalary-1000000)*0.4)+(500000*0.3)+(200000*0.2)+(100000*0.1);
            return new ArrayList<>(Arrays.asList(new Tax(getAnnualSalary(), getID(), getTax())));
        }
    }
}
