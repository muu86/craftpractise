package com.mj.craftpractise.domain.application.impl;

import com.mj.craftpractise.domain.application.GoodsCategoryService;
import com.mj.craftpractise.domain.application.command.AddGoodsCategoryCommand;
import com.mj.craftpractise.domain.model.goods.GoodsCategory;
import com.mj.craftpractise.domain.model.goods.GoodsCategoryRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultGoodsCategoryService implements GoodsCategoryService {

    private final GoodsCategoryRepository goodsCategoryRepository;

    @Override
    public GoodsCategory addGoodsCategory(AddGoodsCategoryCommand command) {
        return null;
    }

    private int getMaxSeq(AddGoodsCategoryCommand command) {
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setLCate(command.getLCate());
        goodsCategory.setMCate(command.getMCate());
        goodsCategory.setSCate(command.getSCate());
        goodsCategory.setDCate(command.getDCate());
        goodsCategory.setLCateName(command.getLCateName());
        goodsCategory.setMCateName(command.getMCateName());
        goodsCategory.setSCateName(command.getSCateName());
        goodsCategory.setDCateName(command.getDCateName());

        if (goodsCategory.getLCate() == null) {
            int nextLCate = goodsCategoryRepository.getNextLCate();
            if (goodsCategory.getLCateName() == null) {
                // 대분류 명을 입력하지 않은 경우 예외처리
            }
        }
            // 파라미터에 카테고리 정보가 다 들어있는 경우
            // 에러 뱉어야 할 듯
    }
}
