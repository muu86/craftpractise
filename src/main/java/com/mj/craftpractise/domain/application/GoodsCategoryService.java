package com.mj.craftpractise.domain.application;

import com.mj.craftpractise.domain.application.command.AddGoodsCategoryCommand;
import com.mj.craftpractise.domain.model.goods.GoodsCategory;

public interface GoodsCategoryService {

    GoodsCategory addGoodsCategory(AddGoodsCategoryCommand command);
}
