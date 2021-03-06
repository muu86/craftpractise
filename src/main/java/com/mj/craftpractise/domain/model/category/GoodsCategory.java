package com.mj.craftpractise.domain.model.category;

import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import com.mj.craftpractise.domain.model.goods.Goods;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 22.04.06
 * Goods * - * Category
 * 연결테이블
 */
@Entity
@IdClass(GoodsCategoryId.class)
public class GoodsCategory extends AbstractBaseEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static GoodsCategory create(Goods goods, Category category) {
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.goods = goods;
        goodsCategory.category = category;
        goodsCategory.createdAt = LocalDateTime.now();
        goodsCategory.modifiedAt = LocalDateTime.now();
        return goodsCategory;
    }
}