package com.mj.craftpractise.domain.model.goods.repository;

import com.mj.craftpractise.domain.model.goods.GoodsBadge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsBadgeRepository extends JpaRepository<GoodsBadge, Long> {

}
