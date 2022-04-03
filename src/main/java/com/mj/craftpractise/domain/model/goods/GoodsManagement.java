package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.infrastructure.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoodsManagement {

    private final GoodsRepository goodsRepository;

    public Goods addGoods(String goodsName,
                        String description,
                        int orderMinQty,
                        int orderMaxQty) {

        Goods goods = Goods.create(goodsName,
                                description,
                                orderMinQty,
                                orderMaxQty);
        return goodsRepository.save(goods);
    }
}
