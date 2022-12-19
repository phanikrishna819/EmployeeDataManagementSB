package com.EmployeeData.EmployeeDataManagement.entity.Tax;

import com.EmployeeData.EmployeeDataManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaxController {

    @Autowired
    TaxService taxService;
    Employee employee;
    public TaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @RequestMapping(method = RequestMethod.GET,value = "EmployeeData/Employees/tax/{EmployeeID}")
    public List<Tax> getTax(@PathVariable int EmployeeID)
    {
        return taxService.getSingleTax(EmployeeID);
    }

}
