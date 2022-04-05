package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GoodsAndGoodsBadge extends AbstractBaseEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @ManyToOne
    @JoinColumn(name = "badge_id")
    private GoodsBadge goodsBadge;

}
