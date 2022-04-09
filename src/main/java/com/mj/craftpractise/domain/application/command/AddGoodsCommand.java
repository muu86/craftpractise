package com.mj.craftpractise.domain.application.command;

import com.mj.craftpractise.domain.model.category.Category;
import com.mj.craftpractise.domain.model.category.GoodsCategory;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class AddGoodsCommand {

    private String goodsName;
    private String description;

    private List<Category> categories;

    private Integer orderMinQty;
    private Integer orderMaxQty;
}
