package com.mj.craftpractise.domain.application;

import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import com.mj.craftpractise.domain.model.goods.Goods;

public interface GoodsService {

    Goods addGoods(AddGoodsCommand command);

//    GoodsCategory addGoodsCategory(AddGoodsCategoryCommand command);
}
