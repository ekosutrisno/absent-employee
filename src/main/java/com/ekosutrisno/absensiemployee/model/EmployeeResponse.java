package com.ekosutrisno.absensiemployee.model;

import com.ekosutrisno.absensiemployee.entity.EmployeeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 11:53
 * @email ekosutrisno801@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private String employeeId;
    private String fullName;
    private String email;
    private String telephone;
    private String statusEmployee;
    private Boolean isActive;
    private List<EmployeeInfo> employeeInfo;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
