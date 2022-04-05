package com.mj.craftpractise.domain.model.goods;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString
@Setter // 테스트용
public class Goods {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String goodsName;   // 상품명

    @Column(nullable = false, length = 300)
    private String description; // 상품 상세 설명

    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL)
    private List<GoodsCategory> goodsCategories = new ArrayList<>();

    // 신상품, 베스트, 추천, 주문폭주 등등
    @OneToMany(mappedBy = "goods", cascade = CascadeType.ALL)
    List<GoodsBadge> goodsBadges = new ArrayList<>();

    @Column(nullable = true)
    private Integer orderMinQty;
    @Column(nullable = true)
    private Integer orderMaxQty;
    @Column(length = 300)
    private String remarks; // 비고란

    @Column(nullable = true)
    private Boolean saleYn; // 판매 중 상품
    @Column(nullable = true)
    private Boolean hiddenYn; // 숨김 상품
    @Column(nullable = true)
    private Boolean useYn; // 상품 삭제

    public static Goods create(String goodsName,
                            String description,
                            Integer orderMinQty,
                            Integer orderMaxQty) {
        Goods goods = new Goods();
        goods.goodsName = goodsName;
        goods.description = description;
        goods.orderMinQty = orderMinQty;
        goods.orderMaxQty = orderMaxQty;
        return goods;
    }
}