package com.mj.craftpractise.web.api.admin;

import com.mj.craftpractise.domain.application.CategoryService;
import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import com.mj.craftpractise.domain.model.category.Category;
import com.mj.craftpractise.web.payload.AddCategoryPayload;
import com.mj.craftpractise.web.result.AddCategoryResult;
import com.mj.craftpractise.web.result.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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

    @PostMapping(
        value = "/add",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResult> addcategory(@RequestBody AddCategoryPayload payload) {
        AddCategoryCommand command = payload.toCommand();
        Category category = categoryService.addcategory(command);
        return AddCategoryResult.build(category);
    }
}
