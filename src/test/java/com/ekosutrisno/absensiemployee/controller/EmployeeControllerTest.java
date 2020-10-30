package com.ekosutrisno.absensiemployee.controller;

import com.ekosutrisno.absensiemployee.entity.EmployeeInfo;
import com.ekosutrisno.absensiemployee.model.CreateEmployeeRequest;
import com.ekosutrisno.absensiemployee.model.EmployeeResponse;
import com.ekosutrisno.absensiemployee.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * The type Employee controller test.
 *
 * @Author Eko Sutrisno
 * @Create 21 /10/2020 16:45
 * @email ekosutrisno801 @gmail.com
 */
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        mockMvc = standaloneSetup(employeeController).build();
    }

    /**
     * Register employee.
     *
     * @throws Exception the exception
     */
    @Test
    @DisplayName("UT-01: Add New Employee")
    void registerEmployee() throws Exception {
        // Prepare Sample Params
        CreateEmployeeRequest request = new CreateEmployeeRequest(
                "Aisyah Ayu Asyfa",
                "aisyahayuasyifa@exoapp.com",
                "akucintakamu",
                "082371928902",
                "Placement"
        );

        // Prepare Sample Data
        EmployeeResponse employeeResponse = new EmployeeResponse(
                "A0001",
                "Aisyah Ayu Asyfa",
                "aisyahayuasyifa@exoapp.com",
                "082371928902",
                "Placement",
                false,
                Collections.emptyList(),
                new Date(),
                new Date()
        );

        when(employeeService.register(request)).thenReturn(employeeResponse);

        mockMvc.perform(post("/api/v1/employees")
                .content(new ObjectMapper().writeValueAsString(request))
                .contentType(APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.employeeId").exists())
                .andExpect(jsonPath("$.data.email").value("aisyahayuasyifa@exoapp.com"));
    }

    /**
     * Gets employee by id ok.
     *
     * @throws Exception the exception
     */
    @Test
    @DisplayName("UT-01: Get Employee By Id")
    void getEmployeeByIdOk() throws Exception {
        // List Employee Info
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
                new Date(),
                new Date()
        );

        // When
        when(employeeService.getById("1234")).thenReturn(employeeResponse);

        // Then Result
        mockMvc.perform(get("/api/v1/employees/1234"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.employeeId").exists())
                .andExpect(jsonPath("$.data.employeeInfo[0].employeeId").value("1234"))
                .andExpect(jsonPath("$.data.email").value("ekosutrisno801@gmail.com"));
    }

    /**
     * Gets all employee.
     *
     * @throws Exception the exception
     */
    @Test
    @DisplayName("UT-01: Get All Employee")
    void getAllEmployee() throws Exception {

        // List Employee Info
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

        // List Employee Response
        List<EmployeeResponse> employeeResponseList = Arrays.asList(
                new EmployeeResponse(
                        "1234",
                        "Eko Sutrisno",
                        "ekosutrisno801@gmail.com",
                        "092371928902",
                        "Idle",
                        false,
                        employeeInfoList,
                        new Date(),
                        new Date()
                ),
                new EmployeeResponse(
                        "1235",
                        "Puspita Sari",
                        "puspitasari@gmail.com",
                        "092371928902",
                        "Placement",
                        true,
                        employeeInfoList,
                        new Date(),
                        new Date()
                )
        );

        Pageable pageable = PageRequest.of(0, 10);

        when(employeeService.getAll(pageable)).thenReturn(employeeResponseList);

        mockMvc.perform(get("/api/v1/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].employeeId").exists())
                .andExpect(jsonPath("$.data[1].employeeId").value("1235"))
                .andExpect(jsonPath("$.data[1].employeeInfo[0].location").value("KunCit, JakSel"));
    }
}