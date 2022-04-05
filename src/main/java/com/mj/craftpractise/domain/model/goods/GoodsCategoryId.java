package com.mj.craftpractise.domain.model.goods;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class GoodsCategoryId implements Serializable {

    @Column(name = "l_cate")
    private Integer lCate;

    @Column(name = "m_cate")
    private Integer mCate;

    @Column(name = "s_cate")
    private Integer sCate;

    @Column(name = "d_cate")
    private Integer dCate;

}