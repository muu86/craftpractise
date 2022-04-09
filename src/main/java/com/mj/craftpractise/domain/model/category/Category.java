package com.mj.craftpractise.domain.model.category;

import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 22.04.06
 * lcate, mcate, scate, dcate 를 PK 로 두면
 * 카테고리를 꼭 4단계까지 만들어야 함.
 * 유저가 원하는 단계까지만 만들 수 있도록 별로 Id 컬럼을 둠.
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"goodscategories"})
public class Category extends AbstractBaseEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "l_cate_code", nullable = false)
    private Integer lcateCode;

    @Column(name = "m_cate_code", nullable = true)
    private Integer mcateCode;

    @Column(name = "s_cate_code", nullable = true)
    private Integer scateCode;

    @Column(name = "d_cate_code", nullable = true)
    private Integer dcateCode;

    @Column(name = "l_cate_name", nullable = false)
    private String lcateName;

    @Column(name = "m_cate_name", nullable = true)
    private String mcateName;

    @Column(name = "s_cate_name", nullable = true)
    private String scateName;

    @Column(name = "d_cate_name", nullable = true)
    private String dcateName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GoodsCategory> goodsCategories = new ArrayList<>();

    private boolean useYn;

    public void changeLcate(int lcateCode) {
        this.lcateCode = lcateCode;
    }

    public void setMcate(int mcateCode) {
        this.mcateCode = mcateCode;
    }

    public void changeScate(int scateCode) {
        this.scateCode = scateCode;
    }

    public void changeDcate(int dcateCode) {
        this.dcateCode = dcateCode;
    }

    public static Category craeteAddCategory(Integer lcateCode, Integer mcateCode, Integer scateCode, Integer dcateCode,
                                    String lcateName, String mcateName, String scateName, String dcateName) {
        return new Category(null, lcateCode, mcateCode, scateCode, dcateCode,
                                    lcateName, mcateName, scateName, dcateName, null, true);
    }

}
