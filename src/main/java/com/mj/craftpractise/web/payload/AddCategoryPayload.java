package com.mj.craftpractise.web.payload;

import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddCategoryPayload {

    private Integer lCate;
    private Integer mCate;
    private Integer sCate;
    private Integer dCate;

    private String lCateName;
    private String mCateName;
    private String sCateName;
    private String dCateName;

    public AddCategoryCommand toCommand() {
        return new AddCategoryCommand(lCate, mCate, sCate, dCate, lCateName, mCateName, sCateName,
            dCateName);
    }
}
