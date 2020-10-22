package com.ekosutrisno.absensiemployee.controller;

import com.ekosutrisno.absensiemployee.entity.EmployeeInfo;
import com.ekosutrisno.absensiemployee.model.EmployeeResponse;
import com.ekosutrisno.absensiemployee.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * @Author Eko Sutrisno
 * @Create 21/10/2020 16:45
 * @email ekosutrisno801@gmail.com
 */

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        mockMvc = standaloneSetup(employeeController).build();
    }

    @Test
    @DisplayName("UT-01: Add New Employee")
    void registerEmployee() {
    }

    @Test
    @DisplayName("UT-01: Get Employee By Id")
    void getEmployeeByIdOk() throws Exception {

        List<EmployeeInfo> employeeInfoList = Arrays.asList(
                new EmployeeInfo(
                        "A123",
                        "1234",
                        "Create Food",
                        "KunCit, JakSel",
                        1,
                        1,
                        0,
                        false
                ),
                new EmployeeInfo(
                        "B123",
                        "1234",
                        "Create Drink",
                        "Ambassador, JakSel",
                        1,
                        1,
                        1,
                        true
                )
        );

        // Prepare Sample Data
        EmployeeResponse employeeResponse = new EmployeeResponse(
                "1234",
                "Eko Sutrisno",
                "ekosutrisno801@gmail.com",
                "092371928902",
                "Idle",
                false,
                employeeInfoList,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        // When
        Mockito.when(employeeService.getById("1234")).thenReturn(employeeResponse);

        // Then Result
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees/1234"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.employeeId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.employeeInfo[0].employeeId").value("1234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.email").value("ekosutrisno801@gmail.com"));
    }

    @Test
    @DisplayName("UT-01: Get All Employee")
    void getAllEmployee() {
    }
}