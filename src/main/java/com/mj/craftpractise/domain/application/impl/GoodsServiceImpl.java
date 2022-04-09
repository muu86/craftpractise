package com.mj.craftpractise.domain.application.impl;

import com.mj.craftpractise.domain.application.GoodsService;
import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import com.mj.craftpractise.domain.model.goods.Goods;
import com.mj.craftpractise.domain.model.goods.GoodsManagement;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsManagement goodsManagement;

    @Override
    public Goods addGoods(AddGoodsCommand command) {
        return goodsManagement.addGoods(command);
    }

    /**
     * @param command
     * @return
     */
//    @Override
//    public Goodscategory addGoodscategory(AddGoodscategoryCommand command) {
//        return goodsManagement.addGoodscategory(command);
//    }
}
