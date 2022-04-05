package com.mj.craftpractise.web.api.admin;

import com.mj.craftpractise.domain.application.CategoryService;
import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import com.mj.craftpractise.domain.model.goods.Category;
import com.mj.craftpractise.web.payload.AddCategoryPayload;
import com.mj.craftpractise.web.result.AddCategoryResult;
import com.mj.craftpractise.web.result.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryApiController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<ApiResult> addCategory(@RequestBody AddCategoryPayload payload) {
        AddCategoryCommand command = payload.toCommand();
        Category category = categoryService.addCategory(command);
        return AddCategoryResult.build(category);
    }
}
