package com.mj.craftpractise.web.payload;

import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddGoodPayload {

    @Size(min = 1, max = 50, message = "상품 이름은 1 ~ 50글자 사이로 입력해주세요.")
    @NotNull
    private String goodsName;

    @Size(max = 200, message = "상품 정보는 200 이하로 입력해주세요.")
    private String description;

    private int orderMinQty;

    private int orderMaxQty;

    public AddGoodsCommand toCommand() {
        return new AddGoodsCommand(goodsName, description, orderMinQty, orderMaxQty);
    }
}
