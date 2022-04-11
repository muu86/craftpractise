package com.mj.craftpractise.domain.application;

import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import com.mj.craftpractise.domain.model.goods.Goods;
import java.util.List;

public interface GoodsService {

    Goods addGoods(AddGoodsCommand command);

//    Goodscategory addGoodscategory(AddGoodscategoryCommand command);

    List<Goods> getAllGoods();
}
