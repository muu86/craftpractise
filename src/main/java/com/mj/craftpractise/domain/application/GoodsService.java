package com.mj.craftpractise.domain.application;

import com.mj.craftpractise.domain.application.command.AddGoodsCategoryCommand;
import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import com.mj.craftpractise.domain.model.goods.Goods;
import com.mj.craftpractise.domain.model.goods.GoodsCategory;

public interface GoodsService {

    Goods addGoods(AddGoodsCommand command);

//    GoodsCategory addGoodsCategory(AddGoodsCategoryCommand command);
}
