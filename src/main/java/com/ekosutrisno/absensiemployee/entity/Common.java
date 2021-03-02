package com.ekosutrisno.absensiemployee.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.OffsetDateTime;

/**
 * @Author Eko Sutrisno
 * @Create 18/10/2020 10:55
 * @email ekosutrisno801@gmail.com
 */

@Data
@MappedSuperclass
public class Common {
    @Column(nullable = false, updatable = false)
    protected OffsetDateTime createdAt;

    @Column(nullable = false)
    protected OffsetDateTime modifiedAt;

    @PrePersist
    public void prePersist() {
        createdAt = OffsetDateTime.now();
        modifiedAt = createdAt;
    }

    @PreUpdate
    public void preUpdate() {
        modifiedAt = OffsetDateTime.now();
    }
}
