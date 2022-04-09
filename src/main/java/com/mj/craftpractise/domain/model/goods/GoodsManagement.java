package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import com.mj.craftpractise.domain.model.category.Category;
import com.mj.craftpractise.domain.model.category.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoodsManagement {

    private final GoodsRepository goodsRepository;

    private final CategoryRepository categoryRepository;

    public Goods addGoods(AddGoodsCommand command) {

        Goods goods = Goods.create(command.getGoodsName(),
                                command.getDescription(),
                                command.getOrderMinQty(),
                                command.getOrderMaxQty());

        List<Category> categories = new ArrayList<>();
        if (command.getCategories().size() > 0) {
            for (Category category : command.getCategories()) {

            }
        }

        return goodsRepository.save(goods);
    }

}
