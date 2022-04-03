package com.mj.craftpractise.domain.common.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.CollectionId;

@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String  createdBy;

    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    @Column(nullable = false)
    private String modifiedBy;
}
