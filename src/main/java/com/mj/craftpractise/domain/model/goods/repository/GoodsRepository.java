package com.mj.craftpractise.domain.model.goods.repository;

import com.mj.craftpractise.domain.model.goods.Goods;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    Optional<Goods> findById(Long id);
}
