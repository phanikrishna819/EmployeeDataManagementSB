package com.EmployeeData.EmployeeDataManagement.entity;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Autowired
    ObjectMapper objectMapper;


// Test Case for GetALL():
    @Test
    public void getAllEmployees() throws Exception{
        //Preparation/Stub:
        when(employeeService.findAll()).thenReturn(Arrays.asList(
                new Employee("Phani","Krishna","888994455","phan@gmail.com","",1,75000),
                new Employee("Phani","Krishna","92998877475","phani@gmail.com","",2,95000)
                ));
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/EmployeeData/Employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{},{}]")).andReturn();
    }


// Test Case for PostRequest:
    @Test
    public void getPostEmployees() throws Exception{
        Employee emp = new Employee();
        emp.setEmployeeID(1);
        emp.setMonthlySalary(70000);
        emp.setEmail("phanikrishna@gmial.com");
        emp.setContact("9515757750");
        emp.setLastName("Krishna");
        emp.setFirstName("Phani");
        emp.setDateOfJoining("24Nov");

        mockMvc.perform(post("http://localhost:8080/EmployeeData/Employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emp)))
                .andExpect(status().isOk()).andReturn();
    }


// Test Case for Put Request:
    @Test
    public void getPutEmployees() throws Exception{
        Employee emp = new Employee();
        emp.setEmployeeID(1);
        emp.setMonthlySalary(90000);
        emp.setEmail("phanikrishna@gmial.com");
        emp.setContact("9515757750");
        emp.setLastName("Krishna");
        emp.setFirstName("Phani");
        emp.setDateOfJoining("24Nov");

        MvcResult mvcResult =mockMvc.perform(put("http://localhost:8080/EmployeeData/Employees/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emp))).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


// Test Case for Delete Request:
    @Test
    public void getDeleteEmployees() throws Exception{
        Employee emp = new Employee();
        emp.setEmployeeID(1);
        emp.setMonthlySalary(90000);
        emp.setEmail("phanikrishna@gmial.com");
        emp.setContact("9515757750");
        emp.setLastName("Krishna");
        emp.setFirstName("Phani");
        emp.setDateOfJoining("24Nov");

        MvcResult mvcResult = mockMvc.perform(delete("http://localhost:8080/EmployeeData/Employees/1")
                .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(emp))).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);
        System.out.println("Deleted");
    }


}