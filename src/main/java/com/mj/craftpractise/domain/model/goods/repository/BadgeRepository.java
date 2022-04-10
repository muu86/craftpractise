package com.mj.craftpractise.domain.model.goods.repository;

import com.mj.craftpractise.domain.model.goods.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {

}
