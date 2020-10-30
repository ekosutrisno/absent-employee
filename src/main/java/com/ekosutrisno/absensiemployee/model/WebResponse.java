package com.ekosutrisno.absensiemployee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @JsonFormat(timezone = "GMT+07:00")
    private Date responseDate;
}
