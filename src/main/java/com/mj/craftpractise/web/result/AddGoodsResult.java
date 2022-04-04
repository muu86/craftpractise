package com.mj.craftpractise.web.result;

import com.mj.craftpractise.domain.model.goods.Goods;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddGoodsResult {

    public static ResponseEntity<ApiResult> build(Goods goods) {
        ApiResult apiResult = ApiResult.message("상품이 등록되었습니다.")
            .add("goodsCode", goods.getId())
            .add("goodsName", goods.getGoodsName());
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(apiResult);
    }
}
