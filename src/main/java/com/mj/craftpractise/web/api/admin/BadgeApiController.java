package com.mj.craftpractise.web.api.admin;

import com.mj.craftpractise.domain.application.BadgeService;
import com.mj.craftpractise.domain.model.goods.Badge;
import com.mj.craftpractise.web.payload.AddBadgePayload;
import com.mj.craftpractise.web.result.AddBadgeResult;
import com.mj.craftpractise.web.result.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/badge")
@RequiredArgsConstructor
public class BadgeApiController {

    private final BadgeService badgeService;

    @PostMapping("/add")
    public ResponseEntity<ApiResult> addBadge(@RequestBody AddBadgePayload payload) {
        Badge result = badgeService.addBadge(payload.toCommand());
        return AddBadgeResult.build(result);
    }
}
