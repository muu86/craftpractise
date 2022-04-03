package com.mj.craftpractise.domain.application.command;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class AddGoodsCommand {

    private String goodsName;
    private String description;

    private int orderMinQty;
    private int orderMaxQty;
}
