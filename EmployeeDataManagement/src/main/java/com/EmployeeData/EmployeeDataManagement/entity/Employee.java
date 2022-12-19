package com.EmployeeData.EmployeeDataManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Employee {
    @Id
    private int EmployeeID;
    @Column private String FirstName;
    @Column private String LastName;
    @Column(unique = true)
    private String Contact;
    @Column(unique = true)
    private String Email;
    @Column private String DateOfJoining;
    @Column private int MonthlySalary;

    public Employee() {
    }

    public Employee(String FirstName, String LastName, String Contact, String Email, String DateOfJoining, int EmployeeID, int MonthlySalary) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Contact = Contact;
        this.Email = Email;
        this.DateOfJoining = DateOfJoining;
        this.EmployeeID = EmployeeID;
        this.MonthlySalary = MonthlySalary;
    }





    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDateOfJoining() {
        return DateOfJoining;
    }

    public void setDateOfJoining(String DateOfJoining) {
        this.DateOfJoining = DateOfJoining;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getMonthlySalary() {
        return MonthlySalary;
    }

    public void setMonthlySalary(int MonthlySalary) {
        this.MonthlySalary = MonthlySalary;
    }


}
