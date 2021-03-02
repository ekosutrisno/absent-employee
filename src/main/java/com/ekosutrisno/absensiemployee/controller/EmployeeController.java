package com.ekosutrisno.absensiemployee.controller;

import com.ekosutrisno.absensiemployee.model.CreateEmployeeRequest;
import com.ekosutrisno.absensiemployee.model.EmployeeResponse;
import com.ekosutrisno.absensiemployee.model.WebResponse;
import com.ekosutrisno.absensiemployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 12:21
 * @email ekosutrisno801@gmail.com
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public WebResponse<?> registerEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        EmployeeResponse response = employeeService.register(createEmployeeRequest);

        return new WebResponse<>(
                "v0.0.1",
                200,
                "Success",
                response,
                new Date()
        );
    }

    @GetMapping("/{employeeId}")
    public WebResponse<?> getEmployee(@PathVariable("employeeId") String employeeId) {
        EmployeeResponse response = employeeService.getById(employeeId);

        return new WebResponse<>(
                "v0.0.1",
                200,
                "Success",
                response,
                new Date()
        );
    }

    @GetMapping
    public WebResponse<?> getAllEmployee(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);

        List<EmployeeResponse> response = employeeService.getAll(pageable);

        return new WebResponse<>(
                "v0.0.1",
                200,
                "Success",
                response,
                new Date()
        );
    }
}
