package com.ekosutrisno.absensiemployee.controller;

import com.ekosutrisno.absensiemployee.model.CreateEmployeeRequest;
import com.ekosutrisno.absensiemployee.model.WebResponse;
import com.ekosutrisno.absensiemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 12:21
 * @email ekosutrisno801@gmail.com
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<?> registerEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        var response = employeeService.register(createEmployeeRequest);

        return new WebResponse<>(
                "v0.0.1",
                200,
                "Success",
                response,
                LocalDateTime.now()
        );
    }

    @GetMapping("/{employeeId}")
    public WebResponse<?> getEmployee(@PathVariable("employeeId") String employeeId) {
        var response = employeeService.getById(employeeId);

        return new WebResponse<>(
                "v0.0.1",
                200,
                "Success",
                response,
                LocalDateTime.now()
        );
    }

    @GetMapping
    public WebResponse<?> getAllEmployee(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);

        var response = employeeService.getAll(pageable);

        return new WebResponse<>(
                "v0.0.1",
                200,
                "Success",
                response,
                LocalDateTime.now()
        );
    }
}
