package com.mj.craftpractise.domain.model.goods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;

/**
 * Goods 1 --- * GoodsAndGoodsBadge * --- 1 GoodsBadge
 * 사용자가 새 뱃지를 추가할 수 있도록 GoodsBadge를 별도 Entity로
 */
@Entity
@Getter
public class Badge extends AbstractBaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String badgeName;

    protected Badge() {}

    public static Badge create(String badgeName) {
        Badge badge = new Badge();
        badge.badgeName = badgeName;
        badge.createdAt = LocalDateTime.now();
        badge.modifiedAt = LocalDateTime.now();
        return badge;
    }
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
