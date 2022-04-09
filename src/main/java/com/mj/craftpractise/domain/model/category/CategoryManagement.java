package com.mj.craftpractise.domain.model.category;

import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryManagement {

    private final CategoryRepository categoryRepository;

    public Category addcategory(AddCategoryCommand command) {
        assignCategoryCode(command);
        Category category = createCategoryToAdd(command);

        return categoryRepository.save(category);
    }

    private Category createCategoryToAdd(AddCategoryCommand command) {
        return Category.craeteAddCategory(command.getLcateCode(),
            command.getMcateCode(),
            command.getScateCode(), command.getDcateCode(),
            command.getLcateName(), command.getMcateName(),
            command.getScateName(), command.getDcateName());
    }

    /**
     * 카테고리를 새로 추가할 때 null 값인 category code를
     * 다음 코드 번호로 세팅해서 리턴해준다.
     * @param command
     * @return
     */
    private void assignCategoryCode(AddCategoryCommand command) {

        if (command.getLcateName() == null) {
            throw new CategoryCreationException("대분류명을 입력해주세요.");
        }
        if (command.getLcateCode() == null) {
            int nextLcateCode = getNextLcateCode();
            command.setLcateCode(nextLcateCode);
        }

        if (command.getMcateName() == null) {
            return;
        }
        if (command.getMcateCode() == null) {
            int nextMcateCode = getNextMcateCode(command.getLcateCode());
            command.setMcateCode(nextMcateCode);
        }

        if (command.getScateName() == null) {
            return;
        }
        if (command.getScateName() != null && command.getScateCode() == null) {
            int nextScateCode = getNextScateCode(command.getLcateCode(), command.getMcateCode());
            command.setScateCode(nextScateCode);
        }

        if (command.getDcateName() == null) {
            return;
        }
        if (command.getDcateName() != null && command.getDcateCode() == null) {
            int nextDcateCode = getNextDcateCode(command.getLcateCode(), command.getMcateCode(), command.getScateCode());
            command.setDcateCode(nextDcateCode);
        }
    }

    private int getNextLcateCode() {
        return categoryRepository.getNextLcateCode();
    }

    private int getNextMcateCode(int lcateCode) {
        return categoryRepository.getNextMcateCode(lcateCode);
    }

    private int getNextScateCode(int lcateCode, int mcateCode) {
        return categoryRepository.getNextScateCode(lcateCode, mcateCode);
    }

    private int getNextDcateCode(int lcateCode, int mcateCode, int scateCode) {
        return categoryRepository.getNextDcateCode(lcateCode, mcateCode, scateCode);
    }
}
