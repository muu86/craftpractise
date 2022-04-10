package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.model.goods.repository.GoodsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class GoodsRepositoryTest {

    @Autowired
    GoodsRepository goodsRepository;

    @Test
    void saveGoods() {
        Goods goods = Goods.create("새 상품", "새 상품입니다.", 1, 10);
        goodsRepository.save(goods);

        Goods byId = goodsRepository.findById(1L).orElse(Goods.create("null상품", "null 상품입니다.", 1, 10));
        System.out.println("byId = " + byId);

    }
}