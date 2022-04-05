package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

// Goods entity 와 Category entity 다대다 관계를 해결하기 위한 엔티티
@Entity
public class GoodsAndGoodsCategory extends AbstractBaseEntity {

//    @Id @GeneratedValue
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "goods_id")
//    private Goods goods;
//
//    @MapsId("GoodsCategory")
//    @ManyToOne
//    @JoinColumns({
//        @JoinColumn(name = "l_cate", referencedColumnName = "l_cate"),
//        @JoinColumn(name = "m_cate", referencedColumnName = "m_cate"),
//        @JoinColumn(name = "s_cate", referencedColumnName = "s_cate"),
//        @JoinColumn(name = "d_cate", referencedColumnName = "d_cate"),
//    })
//    private GoodsCategory goodsCategory;

    @EmbeddedId
    private GoodsAndGoodsCategoryId goodsAndGoodsCategoryId;
}
