package com.mj.craftpractise.web.api.admin;

import com.mj.craftpractise.domain.application.GoodsService;
import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import com.mj.craftpractise.domain.model.goods.Goods;
import com.mj.craftpractise.web.payload.AddGoodPayload;
import com.mj.craftpractise.web.result.ApiResult;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GoodsApiController {

    private final GoodsService goodsService;

    @PostMapping("/api/goods/registration")
    public ResponseEntity<ApiResult> registerGoods(@Valid @RequestBody AddGoodPayload payload) {
        AddGoodsCommand addGoodsCommand = payload.toCommand();
        goodsService.addGoods(addGoodsCommand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
