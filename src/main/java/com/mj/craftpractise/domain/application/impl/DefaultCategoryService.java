package com.mj.craftpractise.domain.application.impl;

import com.mj.craftpractise.domain.application.CategoryService;
import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import com.mj.craftpractise.domain.model.goods.Category;
import com.mj.craftpractise.domain.model.goods.CategoryRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultCategoryService implements CategoryService {

    private final CategoryRepository goodsCategoryRepository;

    @Override
    public Category addCategory(AddCategoryCommand command) {
        Category category = new Category();
        category.setLCate(command.getLCate());
        category.setMCate(command.getMCate());
        category.setSCate(command.getSCate());
        category.setDCate(command.getDCate());
        category.setLCateName(command.getLCateName());
        category.setMCateName(command.getMCateName());
        category.setSCateName(command.getSCateName());
        category.setDCateName(command.getDCateName());

        setNextSeq(category);

        return goodsCategoryRepository.save(category);
    }

    /**
     * 카테고리 항목 각각 next max sequence 를 set
     * @param category
     */
    private void setNextSeq(Category category) {
        if (category.getLCate() == null) {
            int nextLCate = goodsCategoryRepository.getNextLCate();
            category.setLCate(nextLCate);

            if (category.getLCateName() == null) {
                // 대분류 명을 입력하지 않은 경우 예외처리
            }
        }
        // 파라미터에 카테고리 정보가 다 들어있는 경우
        // 에러 뱉어야 할 듯

    }
}
