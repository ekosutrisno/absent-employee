package com.ekosutrisno.absensiemployee.controller;

import com.ekosutrisno.absensiemployee.entity.EmployeeInfo;
import com.ekosutrisno.absensiemployee.model.CreateAbsentRequest;
import com.ekosutrisno.absensiemployee.model.WebResponse;
import com.ekosutrisno.absensiemployee.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 13:48
 * @email ekosutrisno801@gmail.com
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/v1/info", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeInfoController {

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<?> createAbsent(@RequestBody CreateAbsentRequest absentRequest) {
        EmployeeInfo employeeInfo = employeeInfoService.createEmployeeInfo(absentRequest);

        return new WebResponse<>(
                "v0.0.1",
                200,
                "Success",
                employeeInfo,
                LocalDateTime.now()
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
                LocalDateTime.now()
        );
    }
}
