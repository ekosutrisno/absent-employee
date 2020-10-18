package com.ekosutrisno.absensiemployee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 11:16
 * @email ekosutrisno801@gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = EmployeeInfo.TABLE_NAME, indexes = {@Index(name = "employee_idx_search", columnList = "employee_id")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo extends Common {
    static final String TABLE_NAME = "tbl_employee_info";

    @Id
    @Column(name = "employee_info_id", nullable = false, length = 36)
    private String employeeInfoId = UUID.randomUUID().toString().replace("-", "");

    @Column(name = "employee_id", nullable = false, length = 36)
    private String employeeId;

    @Column(name = "planning")
    private String planning;

    @Column(name = "location", length = 100, nullable = false)
    private String location;

    @Column(name = "absentMorning")
    private Integer absentMorning = 0;

    @Column(name = "absentAfternoon")
    private Integer absentAfternoon = 0;

    @Column(name = "absentEvening")
    private Integer absentEvening = 0;

    @Column(name = "is_present")
    private Boolean isPresent = false;
}
