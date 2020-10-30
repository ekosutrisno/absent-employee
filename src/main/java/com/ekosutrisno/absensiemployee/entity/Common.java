package com.ekosutrisno.absensiemployee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 10:55
 * @email ekosutrisno801@gmail.com
 */

@Data
@MappedSuperclass
public class Common {
    @JsonFormat(timezone = "GMT+07:00")
    private Date createdAt;
    @JsonFormat(timezone = "GMT+07:00")
    private Date modifiedAt;
}
