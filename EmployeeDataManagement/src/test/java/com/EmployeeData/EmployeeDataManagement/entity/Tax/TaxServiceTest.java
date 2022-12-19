package com.EmployeeData.EmployeeDataManagement.entity.Tax;

import com.EmployeeData.EmployeeDataManagement.entity.Employee;
import com.EmployeeData.EmployeeDataManagement.entity.EmployeeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class TaxServiceTest {


    @Autowired
    TaxService taxService = new TaxService();
    @Autowired
    TaxService checkTaxService = new TaxService();
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired

    @Test
    void getSingleTax() {
//        taxService.setAnnualSalary(360000);
//        taxService.setID("1");
//        taxService.setEmployeeRepository(taxService.employeeRepository);
//        checkTaxService.setID("1");
//        checkTaxService.setAnnualSalary(370000);
//        checkTaxService.setEmployeeRepository(checkTaxService.employeeRepository);
//        assertEquals(checkTaxService.getSingleTax(1),taxService.getSingleTax(1));

        Optional<Employee> employee1 = employeeRepository.findById("1");
        taxService.setAnnualSalary(employee1.get().getMonthlySalary()*12);
        taxService.setID("1");

        checkTaxService.setID("1");
        checkTaxService.setAnnualSalary(924000);

        assertEquals(checkTaxService.getSingleTax(1),taxService.getSingleTax(1));

    }
}