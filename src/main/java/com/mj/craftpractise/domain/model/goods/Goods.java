package com.mj.craftpractise.domain.model.goods;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class Goods {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String goodsName;   // 상품명

    @Column(nullable = false, length = 300)
    private String description; // 상품 상세 설명

    @OneToMany(mappedBy = "goods_id")
    private GoodsAndGoodsCategory goodsAndGoodsCategory;

    @Embedded
    private GoodsBadge goodsBadge;  // 신상품, 베스트, 추천, 주문폭주

    private int orderMinQty;
    private int orderMaxQty;

    @Column(length = 300)
    private String remarks;     // 비고란

    private boolean saleYn;     // 판매 중 상품
    private boolean hiddenYn;   // 숨김 상품

    private boolean useYn;      // 상품 삭제

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