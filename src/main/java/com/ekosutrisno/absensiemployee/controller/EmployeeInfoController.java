package com.ekosutrisno.absensiemployee.controller;

import com.ekosutrisno.absensiemployee.model.CreateAbsentRequest;
import com.ekosutrisno.absensiemployee.model.WebResponse;
import com.ekosutrisno.absensiemployee.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 13:48
 * @email ekosutrisno801@gmail.com
 */
@RestController
@RequestMapping(value = "/api/v1/info", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeInfoController {

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<?> createAbsent(@RequestBody CreateAbsentRequest absentRequest) {
        var employeeInfo = employeeInfoService.createEmployeeInfo(absentRequest);

        return new WebResponse<>(
                "v0.0.1",
                200,
                "Success",
                employeeInfo,
                LocalDateTime.now()
        );
    }
}
