package team.world.best.backend.subscription.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import team.world.best.backend.subscription.domain.LeaseNotice;
import team.world.best.backend.subscription.dto.LeaseNoticeListResponseDto;
import team.world.best.backend.subscription.dto.LeaseNoticeResponseDto;
import team.world.best.backend.subscription.service.SubscriptionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping("/v1/api/subscription/{id}")
    public LeaseNoticeResponseDto findLeaseNotice(@PathVariable String id) {
        LeaseNotice notice = subscriptionService.findLeaseNoticeById(id);
        LeaseNoticeResponseDto dto = new LeaseNoticeResponseDto(notice);
        return dto;
    }

    @GetMapping("/v1/api/subscriptions")
    public LeaseNoticeListResponseDto findLeaseNotices() {
        List<LeaseNotice> leaseNotices = subscriptionService.findLeaseNotices();
        List<LeaseNoticeResponseDto> collect = leaseNotices.stream().map(LeaseNoticeResponseDto::new).collect(Collectors.toList());

        return new LeaseNoticeListResponseDto(collect);
    }
}
