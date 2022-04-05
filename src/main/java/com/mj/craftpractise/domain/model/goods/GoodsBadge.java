package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 22.04.06
 * Goods - Bagges 연결 테이블
 */
@Entity
public class GoodsBadge extends AbstractBaseEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @ManyToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

}
