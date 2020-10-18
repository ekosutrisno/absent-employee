package com.ekosutrisno.absensiemployee.service;

import com.ekosutrisno.absensiemployee.entity.EmployeeInfo;
import com.ekosutrisno.absensiemployee.model.CreateAbsentRequest;

import java.util.List;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 11:52
 * @email ekosutrisno801@gmail.com
 */
public interface EmployeeInfoService {
    EmployeeInfo createEmployeeInfo(CreateAbsentRequest absentRequest);

    List<EmployeeInfo> getEmployeeInfoByEmployeeId(String employeeId);

    EmployeeInfo updateEmployeeInfo(String employeeId, CreateAbsentRequest absentRequest);
}
