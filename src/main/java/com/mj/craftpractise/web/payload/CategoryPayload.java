package com.mj.craftpractise.web.payload;

import com.mj.craftpractise.domain.application.command.CategoryCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CategoryPayload {

    private Integer lcateCode;
    private Integer mcateCode;
    private Integer scateCode;
    private Integer dcateCode;

    public CategoryCommand toCommand() {
        return new CategoryCommand(lcateCode, mcateCode, scateCode, dcateCode);
    }
}
