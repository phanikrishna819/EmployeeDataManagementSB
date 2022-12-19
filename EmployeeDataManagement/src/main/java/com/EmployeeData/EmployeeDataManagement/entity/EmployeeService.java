//package com.EmployeeData.EmployeeDataManagement.entity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//
//public class EmployeeService {
//
//    private EmployeeRepository employeeRepository;
//
//    public int getTaxDeduction(int annual_salary) {
//        if(annual_salary>250000 && annual_salary<=500000)
//        {
//            return (annual_salary-250000)*(5/100) + 12500;
//        }
//        else if(annual_salary>500000 && annual_salary<=750000)
//        {
//            return (annual_salary-500000)*(1/100) + 25000;
//        }
//        else if(annual_salary>750000 && annual_salary<=1000000)
//        {
//            return (annual_salary-750000)*(15/100) + 37000;
//        }
//        else if(annual_salary>1000000 && annual_salary<=1250000)
//        {
//            return (annual_salary-1000000)*(20/100)+50000;
//        }
//        return 0;
//    }
//}
