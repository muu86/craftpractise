package com.mj.craftpractise.domain.model.category;

import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @Transactional
    void nextLCateCode() {
        int nextLCateCode = categoryRepository.getNextLcateCode();
        System.out.println("nextLCateCode = " + nextLCateCode);
    }

    @Test
    @Transactional
    void nextMCateCode() {
        int lCateCode = 1;
        int nextMCateCode = categoryRepository.getNextMcateCode(lCateCode);
        System.out.println("nextMCateCode = " + nextMCateCode);
    }

    @Test
    @Transactional
    void save() {
        Category category = Category.craeteAddCategory(1, 1, null, null,
            "새 카테고리~", "새 m cate", null, null);
        Category saved = categoryRepository.save(category);
        System.out.println("category = " + saved);
    }

//    @Test
//    @Transactional
//    void find() {
//        Category category = Category.craeteAddCategory(1, 1, null, null,
//            "새 카테고리~", "새 m cate", null, null);
//        Category saved = categoryRepository.save(category);
//        List<Category> bylCateCode = categoryRepository.findByLcateCode(1);
//        System.out.println("bylCateCode = " + bylCateCode);
//    }
}