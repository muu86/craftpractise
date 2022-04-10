package com.mj.craftpractise.web.payload;

import com.mj.craftpractise.domain.application.command.AddBadgeCommand;
import lombok.Getter;

@Getter
public class AddBadgePayload {

    private String badgeName;

    public AddBadgeCommand toCommand() {
        return new AddBadgeCommand(badgeName);
    }
}
