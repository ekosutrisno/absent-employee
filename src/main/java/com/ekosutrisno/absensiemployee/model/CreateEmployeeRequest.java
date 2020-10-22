package com.ekosutrisno.absensiemployee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 11:42
 * @email ekosutrisno801@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    private String fullName;
    private String email;
    private String password;
    private String telephone;
    private String statusEmployee;
}
