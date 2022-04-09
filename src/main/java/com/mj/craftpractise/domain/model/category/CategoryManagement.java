package com.mj.craftpractise.domain.model.category;

import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

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
        validate(command);

        Integer nextLcateCode = null;
        Integer nextMcateCode = null;
        Integer nextScateCode = null;
        Integer nextDcateCode = null;

        if (command.getLcateCode() == null && command.getLcateName() != null) {
            nextLcateCode = getNextLcateCode();
            command.setLcateCode(nextLcateCode);
        }

        if (command.getMcateCode() == null && command.getMcateName() != null) {
            nextMcateCode = getNextMcateCode(
                (nextLcateCode == null) ? command.getLcateCode() : nextLcateCode
            );
            command.setMcateCode(nextMcateCode);
        }

        if (command.getScateCode() == null && command.getScateName() != null) {
            nextScateCode = getNextScateCode(
                (nextLcateCode == null) ? command.getLcateCode() : nextLcateCode,
                (nextMcateCode == null) ? command.getMcateCode() : nextMcateCode);
            command.setScateCode(nextScateCode);
        }

        if (command.getDcateName() != null && command.getDcateCode() == null) {
            nextDcateCode = getNextDcateCode(
                (nextLcateCode == null) ? command.getLcateCode() : nextLcateCode,
                (nextMcateCode == null) ? command.getMcateCode() : nextMcateCode,
                (nextScateCode == null) ? command.getScateCode() : nextScateCode);
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

    private void validate(AddCategoryCommand command) {

        // 세뷴류(dcate)를 추가하는 경우
        if (command.getScateCode() != null) {
            if (command.getLcateCode() == null || command.getMcateCode() == null) {
                throw new CategoryCreationException("대분류 혹은 중분류를 설정해주세요.");
            }
            categoryRepository.existsLcateCodeAndMCateCodeAndScateCode(command.getLcateCode(), command.getMcateCode(),
                    command.getScateCode())
                .orElseThrow(() -> new CategoryCreationException("상위 카테고리가 존재하지 않습니다."));
            return;
        }

        // 소분류(scate)를 추가하는 경우
        if (command.getMcateCode() != null) {
            if (command.getLcateCode() == null) {
                throw new CategoryCreationException("대분류를 설정해주세요.");
            }
            categoryRepository.existsLcateCodeAndMcateCode(command.getLcateCode(), command.getMcateCode())
                .orElseThrow(() -> new CategoryCreationException("상위 카테고리가 존재하지 않습니다."));
            return;
        }

        // 중분류(mcate)를 추가하는 경우
        if (command.getLcateCode() != null) {
            categoryRepository.existsLcateCode(command.getLcateCode())
                .orElseThrow(() -> new CategoryCreationException("상위 카테고리가 존재하지 않습니다."));
        }
    }
}
