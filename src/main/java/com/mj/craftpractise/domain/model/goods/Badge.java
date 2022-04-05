package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Goods 1 --- * GoodsAndGoodsBadge * --- 1 GoodsBadge
 * 사용자가 새 뱃지를 추가할 수 있도록 GoodsBadge를 별도 Entity로
 */
@Entity
public class Badge extends AbstractBaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String badgeName;
//    @Column(nullable = true)
//    private boolean newGoodsYn;     // 신상품
//
//    @Column(nullable = true)
//    private boolean bestGoodsYn;    // 베스트
//
//    @Column(nullable = true)
//    private boolean recommendYn;    // (md) 추천
//
//    @Column(nullable = true)
//    private boolean rushOrderYn;    // 주문폭주
}
