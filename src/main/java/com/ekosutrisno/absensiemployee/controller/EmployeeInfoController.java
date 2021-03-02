package com.ekosutrisno.absensiemployee.controller;

import com.ekosutrisno.absensiemployee.entity.EmployeeInfo;
import com.ekosutrisno.absensiemployee.model.CreateAbsentRequest;
import com.ekosutrisno.absensiemployee.model.WebResponse;
import com.ekosutrisno.absensiemployee.service.EmployeeInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 13:48
 * @email ekosutrisno801@gmail.com
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/info", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EmployeeInfoController {


    private final EmployeeInfoService employeeInfoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public WebResponse<?> createAbsent(@RequestBody CreateAbsentRequest absentRequest) {
        EmployeeInfo employeeInfo = employeeInfoService.createEmployeeInfo(absentRequest);

        return new WebResponse<>(
                "v0.0.1",
                200,
                "Success",
                employeeInfo,
                new Date()
        );
    }

    @PutMapping("/{employeeId}")
    public WebResponse<?> getAllEmployee(@PathVariable("employeeId") String employeeId, @RequestBody CreateAbsentRequest createAbsentRequest) {
        EmployeeInfo response = employeeInfoService.updateEmployeeInfo(employeeId, createAbsentRequest);

        return new WebResponse<>(
                "v0.0.1",
                200,
                "Success",
                response,
                new Date()
        );
    }
}
