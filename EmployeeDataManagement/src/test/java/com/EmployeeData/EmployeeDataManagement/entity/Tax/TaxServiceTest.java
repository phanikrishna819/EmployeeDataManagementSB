package com.EmployeeData.EmployeeDataManagement.entity.Tax;

import com.EmployeeData.EmployeeDataManagement.entity.Employee;
import com.EmployeeData.EmployeeDataManagement.entity.EmployeeRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TaxServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private TaxService taxService;




    @Test
    void getSingleTax() throws ChangeSetPersister.NotFoundException {

        //Preparation/Stub:
        Mockito.when(employeeRepository.findById("1")).thenReturn(Optional.of(new Employee("Phani","Krishna","957778885544","phanikrishna9@gmail.com","24Nov",1,40000)));
        //Action:
        List<Tax> tax = taxService.getSingleTax(1);
        //Assertion
        assertEquals(480000,tax.get(0).getAnnual_salary());
    }
}
