package com.mj.craftpractise.domain.application.command;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class AddCategoryCommand {

    private Integer lcateCode;
    private Integer mcateCode;
    private Integer scateCode;
    private Integer dcateCode;

    private String lcateName;
    private String mcateName;
    private String scateName;
    private String dcateName;

//    private LocalDateTime createdAt;
//    private String createdBy;
//    private LocalDateTime modifiedAt;
//    private String modifiedBy;
}
