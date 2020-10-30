package com.ekosutrisno.absensiemployee.model;

import com.ekosutrisno.absensiemployee.entity.EmployeeInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
    @JsonFormat(timezone = "GMT+07:00")
    private Date createdAt;
    @JsonFormat(timezone = "GMT+07:00")
    private Date modifiedAt;
}
