package com.mj.craftpractise.domain.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class AddBadgeCommand {

    private String badgeName;
}
