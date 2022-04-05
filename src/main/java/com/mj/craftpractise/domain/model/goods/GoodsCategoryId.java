package com.mj.craftpractise.domain.model.goods;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
public class GoodsCategoryId implements Serializable {

    private Long goods;

    private Long category;
}