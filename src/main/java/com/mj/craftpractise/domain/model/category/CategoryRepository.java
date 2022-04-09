package com.mj.craftpractise.domain.model.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select "
            + "case "
                + "when (max(t.lcateCode) is null) then 1 "
                + "else (max(t.lcateCode) + 1) "
            + "end "
        + "from Category t")
    int getNextLcateCode();

    @Query("select "
            + "case "
                + "when (max(t.mcateCode) is null) then 1 "
                + "else (max(t.mcateCode) + 1) "
            + "end "
        + "from Category t "
        + "where t.lcateCode = :lcateCode ")
    int getNextMcateCode(@Param("lcateCode") int lcateCode);

    @Query("select "
            + "case "
                + "when (max(t.scateCode) is null) then 1 "
                + "else (max(t.scateCode) + 1) "
            + "end "
        + "from Category t "
        + "where t.lcateCode = :lcateCode and t.mcateCode = :mcateCode")
    int getNextScateCode(@Param("lcateCode") int lcateCode, @Param("mcateCode") int mcateCode);

    @Query("select "
            + "case "
                + "when (max(t.dcateCode) is null) then 1 "
                + "else (max(t.dcateCode) + 1) "
            + "end "
        + "from Category t "
        + "where t.lcateCode = :lcateCode and t.mcateCode = :mcateCode and scateCode = :scateCode")
    int getNextDcateCode(@Param("lcateCode") int lcateCode, @Param("mcateCode") int mcateCode, @Param("scateCode") int scateCode);
}
