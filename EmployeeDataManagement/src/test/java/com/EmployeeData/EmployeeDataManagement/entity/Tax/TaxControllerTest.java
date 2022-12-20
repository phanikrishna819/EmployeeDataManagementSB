package com.EmployeeData.EmployeeDataManagement.entity.Tax;

import com.EmployeeData.EmployeeDataManagement.entity.Employee;
import com.EmployeeData.EmployeeDataManagement.entity.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TaxController.class)
class TaxControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TaxService taxService;

    @InjectMocks
    TaxController taxController;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void GetAllTax() throws Exception {


        Mockito.when(taxService.getSingleTax(1)).thenReturn(Arrays.asList(
                new Tax(750000,1,28000)
        ));

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/EmployeeData/Employees/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("[{},{}]")).andReturn();
    }
}