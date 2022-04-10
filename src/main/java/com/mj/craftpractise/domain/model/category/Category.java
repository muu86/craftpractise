package com.mj.craftpractise.domain.model.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mj.craftpractise.domain.common.model.AbstractBaseEntity;
import java.time.LocalDateTime;
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

    public static Category craeteAddCategory(Integer lcateCode, Integer mcateCode, Integer scateCode, Integer dcateCode,
                                    String lcateName, String mcateName, String scateName, String dcateName) {
        Category category = new Category();
        category.lcateCode = lcateCode;
        category.mcateCode = mcateCode;
        category.scateCode = scateCode;
        category.dcateCode = dcateCode;
        category.lcateName = lcateName;
        category.mcateName = mcateName;
        category.scateName = scateName;
        category.dcateName = dcateName;
        category.createdAt = LocalDateTime.now();
        category.modifiedAt = LocalDateTime.now();
        return category;
    }

}
