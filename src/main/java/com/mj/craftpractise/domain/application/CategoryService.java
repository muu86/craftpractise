package com.mj.craftpractise.domain.application;

import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import com.mj.craftpractise.domain.model.category.Category;

public interface CategoryService {

    Category addcategory(AddCategoryCommand command);
}
