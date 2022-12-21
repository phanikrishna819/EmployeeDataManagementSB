package com.EmployeeData.EmployeeDataManagement.entity;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    // Find all Employees Method Test Case:
    @Test
    public void findAll() throws Exception{
        Mockito.when(employeeService.findAll()).thenReturn(Arrays.asList(
                new Employee("Phani","Krishna","95157577555","phanikrishna819@gmial.com","",1,77000),
                new Employee("Phani","Krishna","9515757000","phani@gmial.com","",2,88900)
                ));

        List<Employee> AllEmployees = employeeService.findAll();

        assertEquals(77000,AllEmployees.get(0).getMonthlySalary());
        assertEquals(88900,AllEmployees.get(1).getMonthlySalary());
    }

// Post Method Test Case:
    @Test
    public void post() throws  Exception{
        Employee e = new Employee("Phani","Krishna","9517788999","phanikrishna9@gmail.com","24Nov",1,40000);
        Mockito.when(employeeRepository.save(e)).thenReturn(e);

        assertEquals(1,e.getEmployeeID());
    }


// Put Method Test Case:
    @Test
    public void put() throws Exception{
        Employee e = new Employee("Phani","Krishna","9517788999","phanikrishna9@gmail.com","24Nov",1,40000);
        e.setContact("9517788111");
        Mockito.when(employeeRepository.save(e)).thenReturn(e);
        assertEquals("9517788111", e.getContact());
        System.out.println(e.getContact());
    }


// Delete Method Test Case:
    @Test
    public void delete() throws Exception{
        Employee e = new Employee();
//        e.setEmployeeID(1);
//        int id= e.getEmployeeID();
//        Mockito.when(employeeRepository.findById(1)).thenReturn(Optional.ofNullable(e));
//        willDoNothing().given(employeeRepository).deleteById(id);
        employeeService.delete(e);
        System.out.println("DELETED");
        verify(employeeRepository).delete(e);
        assertFalse(this.employeeRepository.existsById(1));
    }

}