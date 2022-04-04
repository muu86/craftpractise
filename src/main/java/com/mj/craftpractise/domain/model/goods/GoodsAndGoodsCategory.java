package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

// Goods entity 와 Category entity 다대다 관계를 해결하기 위한 엔티티
@Entity
public class GoodsAndGoodsCategory extends AbstractBaseEntity {

    @EmbeddedId
    private GoodsAndGoodsCategoryId id;
}
