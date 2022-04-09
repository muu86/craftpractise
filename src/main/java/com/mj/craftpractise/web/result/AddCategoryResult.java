package com.mj.craftpractise.web.result;

import com.mj.craftpractise.domain.model.category.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddCategoryResult {

    public static ResponseEntity<ApiResult> build(Category category) {
        ApiResult apiResult = ApiResult.message("카테고리가 등록되었습니다.")
            .add("lcateCode", category.getLcateCode())
            .add("lcateName", category.getLcateName())
            .add("mcateCode", category.getMcateCode())
            .add("mcateName", category.getMcateName())
            .add("scateCode", category.getScateCode())
            .add("scateName", category.getScateName())
            .add("dcateCode", category.getDcateCode())
            .add("dcateName", category.getDcateName());
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(apiResult);
    }
}
