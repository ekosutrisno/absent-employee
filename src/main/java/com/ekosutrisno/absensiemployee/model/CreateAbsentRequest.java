package com.ekosutrisno.absensiemployee.model;

import lombok.Data;

import javax.persistence.Column;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 13:08
 * @email ekosutrisno801@gmail.com
 */
@Data
public class CreateAbsentRequest {
    private String employeeId;
    private String planning;
    private String location;
    private Integer absentMorning;
    private Integer absentAfternoon;
    private Integer absentEvening;
}

