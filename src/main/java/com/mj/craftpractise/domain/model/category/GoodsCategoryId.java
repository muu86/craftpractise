package com.mj.craftpractise.domain.model.category;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
public class GoodsCategoryId implements Serializable {

    private Long goods;

    private Long category;

    public static GoodsCategoryId create(Long goodsId, Long categoryId) {
        GoodsCategoryId goodsCategoryId = new GoodsCategoryId();
        goodsCategoryId.goods = goodsId;
        goodsCategoryId.category = categoryId;
        return goodsCategoryId;
    }
}