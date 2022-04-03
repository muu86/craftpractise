package com.mj.craftpractise.domain.application.impl;

import com.mj.craftpractise.domain.application.GoodsService;
import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import com.mj.craftpractise.domain.model.goods.Goods;
import com.mj.craftpractise.domain.model.goods.GoodsManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultGoodsService implements GoodsService {

    private final GoodsManagement goodsManagement;

    @Override
    public Goods addGoods(AddGoodsCommand command) {
        return goodsManagement.addGoods(
            command.getGoodsName(),
            command.getDescription(),
            command.getOrderMinQty(),
            command.getOrderMaxQty()
        );
    }
}