package com.mj.craftpractise.domain.application.command;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class AddGoodsCategoryCommand {

    private Integer lCate;
    private Integer MCate;
    private Integer sCate;
    private Integer dCate;

    private String lCateName;
    private String mCateName;
    private String sCateName;
    private String dCateName;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
