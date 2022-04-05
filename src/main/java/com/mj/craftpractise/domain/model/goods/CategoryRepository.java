package com.mj.craftpractise.domain.model.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select "
        + "case "
        + "when (max(t.lCate) is null) then 1 "
        + "else (max(t.lCate) + 1) "
        + "end "
        + "from Category t")
    int getNextLCate();
}
