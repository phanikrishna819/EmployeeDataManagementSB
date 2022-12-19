package com.EmployeeData.EmployeeDataManagement.entity.Tax;


import com.EmployeeData.EmployeeDataManagement.entity.Employee;

public class Tax {

    private int annual_salary;
    private String EmployeeID;
    private double TaxDeduction;



    public Tax() {
    }

    public Tax(int annual_salary, String EmployeeID, double taxDeduction) {
        this.annual_salary = annual_salary;
        this.EmployeeID = EmployeeID;
        this.TaxDeduction = taxDeduction;
    }

    public int getAnnual_salary() {
        return annual_salary;
    }

    public void setAnnual_salary(int annual_salary) {
        this.annual_salary = annual_salary;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public double getTaxDeduction() {
        return TaxDeduction;
    }

    public void setTaxDeduction(double taxDeduction) {
        TaxDeduction = taxDeduction;
    }


}
