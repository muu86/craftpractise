package com.mj.craftpractise.domain.common.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

/**
 * 22.04.06
 * 테스트용으로 nullable false 로 설정
 */
@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Column(nullable = false)
    protected LocalDateTime createdAt;

//    @Column(nullable = false)
    protected String createdBy;

    @Column(nullable = false)
    protected LocalDateTime modifiedAt;

//    @Column(nullable = false)
    protected String modifiedBy;
}
