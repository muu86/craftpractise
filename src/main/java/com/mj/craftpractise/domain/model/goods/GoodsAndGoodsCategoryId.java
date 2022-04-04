package com.mj.craftpractise.domain.model.goods;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class GoodsAndGoodsCategoryId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Long goodsId;

    @MapsId("GoodsCategory")
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "l_cate", referencedColumnName = "l_cate"),
        @JoinColumn(name = "m_cate", referencedColumnName = "m_cate"),
        @JoinColumn(name = "s_cate", referencedColumnName = "s_cate"),
        @JoinColumn(name = "d_cate", referencedColumnName = "d_cate")
    })
    private GoodsCategory goodsCategory;
}
