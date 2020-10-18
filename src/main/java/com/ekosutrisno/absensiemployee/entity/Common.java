package com.ekosutrisno.absensiemployee.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 10:55
 * @email ekosutrisno801@gmail.com
 */

@Data
@MappedSuperclass
public class Common {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
