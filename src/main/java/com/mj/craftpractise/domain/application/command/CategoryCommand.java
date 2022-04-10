package com.mj.craftpractise.domain.application.command;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class CategoryCommand {

    private Integer lcateCode;
    private Integer mcateCode;
    private Integer scateCode;
    private Integer dcateCode;

}
