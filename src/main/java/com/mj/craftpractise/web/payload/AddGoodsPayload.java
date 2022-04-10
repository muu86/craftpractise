package com.mj.craftpractise.web.payload;

import com.mj.craftpractise.domain.application.command.AddGoodsCommand;
import com.mj.craftpractise.domain.application.command.CategoryCommand;
import com.mj.craftpractise.domain.model.goods.Badge;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AddGoodsPayload {

    @Size(min = 1, max = 50, message = "상품 이름은 1 ~ 50글자 사이로 입력해주세요.")
    @NotNull
    private String goodsName;

    @Size(max = 200, message = "상품 정보는 200 이하로 입력해주세요.")
    private String description;

    private List<CategoryPayload> categories;

    private List<Badge> badges;

    private int orderMinQty;

    private int orderMaxQty;

    public AddGoodsCommand toCommand() {
        return new AddGoodsCommand(goodsName, description, toCommandList(categories), badges, orderMinQty, orderMaxQty);
    }

    private List<CategoryCommand> toCommandList(List<CategoryPayload> payloads) {
        List<CategoryCommand> commands = new ArrayList<>();
        for (CategoryPayload payload : payloads) {
            commands.add(payload.toCommand());
        }
        return commands;
    }
}
