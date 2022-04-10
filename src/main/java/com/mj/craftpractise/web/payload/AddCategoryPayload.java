package com.mj.craftpractise.web.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mj.craftpractise.domain.application.command.AddCategoryCommand;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class AddCategoryPayload {

    private Integer lcateCode;
    private Integer mcateCode;
    private Integer scateCode;
    private Integer dcateCode;

    @NotNull
    private String lcateName;
    private String mcateName;
    private String scateName;
    private String dcateName;

    @JsonIgnore
    public AddCategoryCommand toCommand() {
        return new AddCategoryCommand(lcateCode, mcateCode, scateCode, dcateCode, lcateName,
            mcateName, scateName,
            dcateName);
    }
}
