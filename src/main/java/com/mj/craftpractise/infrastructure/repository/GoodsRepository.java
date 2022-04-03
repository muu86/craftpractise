package com.mj.craftpractise.infrastructure.repository;

import com.mj.craftpractise.domain.model.goods.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

}
