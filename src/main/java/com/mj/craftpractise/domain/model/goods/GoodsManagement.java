package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoodsManagement {

    private final GoodsRepository goodsRepository;

    public Goods addGoods(AddGoodsCommand command) {

        Goods goods = Goods.create(command.getGoodsName(),
                                command.getDescription(),
                                command.getOrderMinQty(),
                                command.getOrderMaxQty());
        return goodsRepository.save(goods);
    }

}
