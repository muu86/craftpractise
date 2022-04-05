package com.mj.craftpractise.domain.model.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory, Long> {

    @Query("select "
        + "max(t.lCate) + 1 "
        + "from GoodsCategory t")
    Integer getNextLCate();
}
