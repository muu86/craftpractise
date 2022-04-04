package com.mj.craftpractise.domain.model.goods;

import javax.persistence.Embeddable;

@Embeddable
public class GoodsBadge {

    private boolean newGoodsYn;     // 신상품

    private boolean bestGoodsYn;    // 베스트

    private boolean recommendYn;    // (md) 추천

    private boolean rushOrderYn;    // 주문폭주
}
