package com.mj.craftpractise.web.result;

import com.mj.craftpractise.domain.model.goods.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddCategoryResult {

    public static ResponseEntity<ApiResult> build(Category category) {
        ApiResult apiResult = ApiResult.message("카테고리가 등록되었습니다.")
            .add("lCate", category.getLCate())
            .add("lCateName", category.getLCateName());
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(apiResult);
    }
}
