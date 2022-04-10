package com.mj.craftpractise.web.result;

import com.mj.craftpractise.domain.model.goods.Badge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddBadgeResult {

    public static ResponseEntity<ApiResult> build(Badge badge) {
        ApiResult result = ApiResult.message("뱃지가 등록되었습니다")
            .add("badgeName", badge.getBadgeName());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
