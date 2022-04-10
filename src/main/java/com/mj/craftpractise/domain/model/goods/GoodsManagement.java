package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import com.mj.craftpractise.domain.application.command.CategoryCommand;
import com.mj.craftpractise.domain.model.category.Category;
import com.mj.craftpractise.domain.model.category.CategoryRepository;
import com.mj.craftpractise.domain.model.category.GoodsCategory;
import com.mj.craftpractise.domain.model.category.GoodsCategoryRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoodsManagement {

    private final GoodsRepository goodsRepository;

    private final CategoryRepository categoryRepository;

    private final GoodsCategoryRepository goodsCategoryRepository;

    public Goods addGoods(AddGoodsCommand command) {
        Goods goods = Goods.create(command.getGoodsName(),
            command.getDescription(),
            command.getOrderMinQty(),
            command.getOrderMaxQty());
        goods = goodsRepository.save(goods);

        List<Category> categories = new ArrayList<>();
        if (command.getCategories().size() > 0) {
            for (CategoryCommand categoryCommand : command.getCategories()) {
                categories.add(getCategoryFromCategoryCommand(categoryCommand));
            }
        }

        List<GoodsCategory> goodsCategories = new ArrayList<>();
        for (Category category : categories) {
            goodsCategories.add(GoodsCategory.create(goods, category));
        }
        goodsCategoryRepository.saveAll(goodsCategories);

        return goods;
    }

    private Category getCategoryFromCategoryCommand(CategoryCommand command) {
        if (command.getDcateCode() != null) {
            return categoryRepository.findByLcateCodeAndMcateCodeAndScateCodeAndDcateCode(
                command.getLcateCode(),
                command.getMcateCode(), command.getScateCode(), command.getDcateCode())
                .orElseThrow(() -> new GoodsCreationException("카테고리가 존재하지 않습니다."));
        }

        if (command.getScateCode() != null) {
            return categoryRepository.findByLcateCodeAndMcateCodeAndScateCodeAndDcateCodeIsNull(
                command.getLcateCode(),
                command.getMcateCode(), command.getScateCode())
                .orElseThrow(() -> new GoodsCreationException("카테고리가 존재하지 않습니다."));
        }

        if (command.getMcateCode() != null) {
            return categoryRepository.findByLcateCodeAndMcateCodeAndScateCodeIsNull(
                command.getLcateCode(), command.getMcateCode())
                .orElseThrow(() -> new GoodsCreationException("카테고리가 존재하지 않습니다."));
        }

        return categoryRepository.findByLcateCodeAndMcateCodeIsNull(command.getLcateCode())
            .orElseThrow(() -> new GoodsCreationException("카테고리가 존재하지 않습니다."));
    }
}
