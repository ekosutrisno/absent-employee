package com.ekosutrisno.absensiemployee.service;

import com.ekosutrisno.absensiemployee.entity.Employee;
import com.ekosutrisno.absensiemployee.model.CreateEmployeeRequest;
import com.ekosutrisno.absensiemployee.model.EmployeeResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 11:52
 * @email ekosutrisno801@gmail.com
 */
public interface EmployeeService {
    EmployeeResponse register(CreateEmployeeRequest createEmployeeRequest);

    EmployeeResponse getById(String employeeId);

    List<EmployeeResponse> getAll(Pageable pageable);
}
