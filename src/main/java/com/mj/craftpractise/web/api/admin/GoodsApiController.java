package com.mj.craftpractise.web.api.admin;

import com.mj.craftpractise.domain.application.GoodsService;
import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import com.mj.craftpractise.domain.model.goods.Goods;
import com.mj.craftpractise.web.payload.AddGoodsPayload;
import com.mj.craftpractise.web.result.AddGoodsResult;
import com.mj.craftpractise.web.result.ApiResult;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/goods")
@RequiredArgsConstructor
public class GoodsApiController {

    private final GoodsService goodsService;

    @PostMapping("/add")
    public ResponseEntity<ApiResult> addGoods(@Valid @RequestBody AddGoodsPayload payload) {
        AddGoodsCommand addGoodsCommand = payload.toCommand();
        Goods result = goodsService.addGoods(addGoodsCommand);
        return AddGoodsResult.build(result);
    }
}
