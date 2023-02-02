package team.world.best.backend.subscription.service;


import team.world.best.backend.subscription.domain.LeaseNotice;

import java.util.List;


public interface SubscriptionService {
    LeaseNotice findLeaseNoticeById(String id);
    List<LeaseNotice> findLeaseNotices();
}
