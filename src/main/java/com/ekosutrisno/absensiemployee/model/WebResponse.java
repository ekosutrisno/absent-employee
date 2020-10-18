package com.ekosutrisno.absensiemployee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 11:44
 * @email ekosutrisno801@gmail.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebResponse<T> {
    private String apiVersion;
    private Integer statusCode;
    private String statusMessage;
    private T data;
    private LocalDateTime responseDate;
}
