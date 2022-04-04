package com.mj.craftpractise.web.api.admin;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mj.craftpractise.domain.application.GoodsService;
import com.mj.craftpractise.domain.model.goods.Goods;
import com.mj.craftpractise.util.JsonUtil;
import com.mj.craftpractise.web.payload.AddGoodsPayload;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class GoodsApiControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GoodsService goodsServiceMock;

    @Test
    public void 공백요청바디_addGoods_400리턴() throws Exception {
        mvc.perform(post("/api/goods/add"))
            .andDo(print())
            .andExpect(status().is(400));
    }

    @Test
    public void 정당한요청바디_addGoods_201리턴() throws Exception {
        AddGoodsPayload payload = new AddGoodsPayload();
        payload.setGoodsName("상품테스트");
        payload.setDescription("상품설명");
        payload.setOrderMinQty(1);
        payload.setOrderMaxQty(100);

        doReturn(Goods.create(payload.getGoodsName(),
                            payload.getDescription(),
                            payload.getOrderMinQty(),
                            payload.getOrderMaxQty()))
            .when(goodsServiceMock).addGoods(payload.toCommand());

        mvc.perform(
            post("/api/goods/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(payload)))
            .andDo(print())
            .andExpect(status().is(201));
    }
}