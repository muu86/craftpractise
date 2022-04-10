package com.mj.craftpractise.domain.application.impl;

import com.mj.craftpractise.domain.application.BadgeService;
import com.mj.craftpractise.domain.application.command.AddBadgeCommand;
import com.mj.craftpractise.domain.model.goods.Badge;
import com.mj.craftpractise.domain.model.goods.repository.BadgeRepository;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BadgeServiceImpl implements BadgeService {

    private final BadgeRepository badgeRepository;

    @Override
    public Badge addBadge(AddBadgeCommand command) {
        Badge badge = Badge.create(command.getBadgeName());
        badge = badgeRepository.save(badge);
        return badge;
    }

}
