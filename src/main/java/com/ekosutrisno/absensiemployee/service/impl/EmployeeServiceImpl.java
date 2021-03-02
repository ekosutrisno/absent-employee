package com.ekosutrisno.absensiemployee.service.impl;

import com.ekosutrisno.absensiemployee.entity.Employee;
import com.ekosutrisno.absensiemployee.entity.EmployeeInfo;
import com.ekosutrisno.absensiemployee.model.CreateEmployeeRequest;
import com.ekosutrisno.absensiemployee.model.EmployeeResponse;
import com.ekosutrisno.absensiemployee.repository.EmployeeRepository;
import com.ekosutrisno.absensiemployee.service.EmployeeInfoService;
import com.ekosutrisno.absensiemployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 12:02
 * @email ekosutrisno801@gmail.com
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeInfoService employeeInfoService;

    @Override
    public EmployeeResponse register(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = new Employee();
        employee.setFullName(createEmployeeRequest.getFullName());
        employee.setEmail(createEmployeeRequest.getEmail());
        employee.setPassword(createEmployeeRequest.getPassword());
        employee.setTelephone(createEmployeeRequest.getTelephone());
        employee.setStatusEmployee(createEmployeeRequest.getStatusEmployee());

        Employee dataSaved = employeeRepository.save(employee);

        return new EmployeeResponse(
                dataSaved.getEmployeeId(),
                dataSaved.getFullName(),
                dataSaved.getEmail(),
                dataSaved.getTelephone(),
                dataSaved.getStatusEmployee(),
                dataSaved.getIsActive(),
                Collections.emptyList(),
                dataSaved.getCreatedAt(),
                dataSaved.getModifiedAt()
        );
    }

    @Override
    public EmployeeResponse getById(String employeeId) {
        Optional<Employee> employeeData = employeeRepository.findById(employeeId);

        Employee employee = new Employee();

        if (employeeData.isPresent() && employeeData.get().getIsActive()) {
            employee = employeeData.get();

            List<EmployeeInfo> employeeInfo = employeeInfoService
                    .getEmployeeInfoByEmployeeId(employee.getEmployeeId());

            return new EmployeeResponse(
                    employee.getEmployeeId(),
                    employee.getFullName(),
                    employee.getEmail(),
                    employee.getTelephone(),
                    employee.getStatusEmployee(),
                    employee.getIsActive(),
                    employeeInfo,
                    employee.getCreatedAt(),
                    employee.getModifiedAt()
            );
        }

        return null;
    }

    @Override
    public List<EmployeeResponse> getAll(Pageable pageable) {
        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        return employeePage.get().filter(Employee::getIsActive)
                .map(employee ->
                        new EmployeeResponse(
                                employee.getEmployeeId(),
                                employee.getFullName(),
                                employee.getEmail(),
                                employee.getTelephone(),
                                employee.getStatusEmployee(),
                                employee.getIsActive(),
                                employeeInfoService
                                        .getEmployeeInfoByEmployeeId(employee.getEmployeeId()),
                                employee.getCreatedAt(),
                                employee.getModifiedAt()
                        )
                ).collect(Collectors.toList());
    }
}
