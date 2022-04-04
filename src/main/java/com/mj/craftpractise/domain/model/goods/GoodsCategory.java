package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class GoodsCategory extends AbstractBaseEntity {

    @EmbeddedId
    private GoodsCategoryId id;

    @OneToMany(mappedBy = "")
    private GoodsAndGoodsCategory goodsAndGoodsCategory;

    @Column(name = "l_cate_name")
    private String lCateName;

    @Column(name = "m_cate_name")
    private String mCateName;

    @Column(name = "s_cate_name")
    private String sCateName;

    @Column(name = "d_cate_name")
    private String dCateName;

    private boolean useYn;
}
