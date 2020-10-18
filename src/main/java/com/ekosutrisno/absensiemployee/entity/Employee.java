package com.ekosutrisno.absensiemployee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 10:46
 * @email ekosutrisno801@gmail.com
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = Employee.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Common {

    static final String TABLE_NAME = "tbl_employee";

    @Id
    @Column(name = "employee_id", nullable = false, length = 36)
    private String employeeId = UUID.randomUUID().toString().replace("-", "");

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telephone", nullable = false, length = 36)
    private String telephone;

    @Column(name = "status_employee", nullable = false, length = 36)
    private String statusEmployee;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;
}
