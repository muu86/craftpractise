package com.mj.craftpractise.domain.application;

import com.mj.craftpractise.domain.application.command.AddBadgeCommand;
import com.mj.craftpractise.domain.model.goods.Badge;
import org.springframework.stereotype.Service;

public interface BadgeService {

    Badge addBadge(AddBadgeCommand command);
}
