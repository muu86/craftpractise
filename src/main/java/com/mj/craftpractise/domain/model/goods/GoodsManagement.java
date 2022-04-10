package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import com.mj.craftpractise.domain.application.command.CategoryCommand;
import com.mj.craftpractise.domain.model.category.Category;
import com.mj.craftpractise.domain.model.category.repository.CategoryRepository;
import com.mj.craftpractise.domain.model.category.GoodsCategory;
import com.mj.craftpractise.domain.model.category.repository.GoodsCategoryRepository;
import com.mj.craftpractise.domain.model.goods.repository.BadgeRepository;
import com.mj.craftpractise.domain.model.goods.repository.GoodsBadgeRepository;
import com.mj.craftpractise.domain.model.goods.repository.GoodsRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoodsManagement {

    private final GoodsRepository goodsRepository;

    private final CategoryRepository categoryRepository;
    private final GoodsCategoryRepository goodsCategoryRepository;

    private final BadgeRepository badgeRepository;
    private final GoodsBadgeRepository goodsBadgeRepository;

    public Goods addGoods(AddGoodsCommand command) {
        Goods goods = Goods.create(command.getGoodsName(),
            command.getDescription(),
            command.getOrderMinQty(),
            command.getOrderMaxQty());
        goods = goodsRepository.save(goods);


        // 상품 카테고리 등록
        List<Category> categories;
        if (command.getCategories().size() > 0) {
            categories = new ArrayList<>();
            for (CategoryCommand categoryCommand : command.getCategories()) {
                categories.add(getCategoryFromCategoryCommand(categoryCommand));
            }

            List<GoodsCategory> goodsCategories = new ArrayList<>();
            for (Category category : categories) {
                goodsCategories.add(GoodsCategory.create(goods, category));
            }
            goodsCategoryRepository.saveAll(goodsCategories);
        }

        // 상품 뱃지 등록
        List<GoodsBadge> goodsBadges;
        if (command.getBadges().size() > 0) {
            goodsBadges = new ArrayList<>();
            for (Badge badge : command.getBadges()) {
                badgeRepository.findById(badge.getId())
                    .orElseThrow(() ->
                        new GoodsCreationException("등록되지 않은 뱃지입니다. 뱃지를 먼저 등록해주세요."));

                goodsBadges.add(GoodsBadge.create(goods, badge));
            }
            goodsBadgeRepository.saveAll(goodsBadges);
        }

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
