package com.mj.craftpractise.domain.application.impl;

import com.mj.craftpractise.domain.application.CategoryService;
import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import com.mj.craftpractise.domain.model.category.Category;
import com.mj.craftpractise.domain.model.category.CategoryManagement;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryManagement categoryManagement;

    @Override
    public Category addcategory(AddCategoryCommand command) {

        return categoryManagement.addcategory(command);
    }

}
