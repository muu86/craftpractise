package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class Goods {

    @Id @GeneratedValue
    private Long goodsCode;
    private String goodsName;
    
    private String description;
    
    private int orderMinQty;
    private int orderMaxQty;

    public static Goods create(String goodsName,
                            String description,
                            int orderMinQty,
                            int orderMaxQty) {
        Goods goods = new Goods();
        goods.goodsName = goodsName;
        goods.description = description;
        goods.orderMinQty = orderMinQty;
        goods.orderMaxQty = orderMaxQty;
        return goods;
    }
}