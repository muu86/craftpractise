package com.mj.craftpractise.domain.application;

import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import com.mj.craftpractise.domain.model.goods.Category;

public interface CategoryService {

    Category addCategory(AddCategoryCommand command);
}
