package com.mj.craftpractise.domain.model.goods;

import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * 22.04.06
 * lCate, mCate, sCate, dCate 를 PK 로 두면
 * 카테고리를 꼭 4단계까지 만들어야 함.
 * 유저가 원하는 단계까지만 만들 수 있도록 별로 Id 컬럼을 둠.
 */
@Entity
@Getter @Setter
public class Category extends AbstractBaseEntity {

    @Id @GeneratedValue
    private Long id;

    private Integer lCate;
    private Integer mCate;
    private Integer sCate;
    private Integer dCate;

    @Column(name = "l_cate_name")
    private String lCateName;

    @Column(name = "m_cate_name")
    private String mCateName;

    @Column(name = "s_cate_name")
    private String sCateName;

    @Column(name = "d_cate_name")
    private String dCateName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<GoodsCategory> goodsCategories = new ArrayList<>();

    private boolean useYn;
}
