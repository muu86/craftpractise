package com.mj.craftpractise.domain.model.category.repository;

import com.mj.craftpractise.domain.model.category.GoodsCategory;
import com.mj.craftpractise.domain.model.category.GoodsCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory, GoodsCategoryId> {

}
