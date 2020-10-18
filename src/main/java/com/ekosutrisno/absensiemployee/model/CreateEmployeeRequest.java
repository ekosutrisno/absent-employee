package com.ekosutrisno.absensiemployee.model;

import lombok.Data;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 11:42
 * @email ekosutrisno801@gmail.com
 */
@Data
public class CreateEmployeeRequest {
    private String fullName;
    private String email;
    private String password;
    private String telephone;
    private String statusEmployee;
}
