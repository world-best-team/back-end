package team.world.best.backend.subscription.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.world.best.backend.subscription.domain.LeaseNotice;
import team.world.best.backend.subscription.repository.LeaseNoticeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubscriptionServiceImpl implements SubscriptionService{
    private final LeaseNoticeRepository leaseNoticeRepository;

    @Override
    public LeaseNotice findLeaseNoticeById(String id) {
        LeaseNotice notice = leaseNoticeRepository.findById(id);
        notice.view();
        return notice;
    }

    @Override
    public List<LeaseNotice> findLeaseNotices() {
        return leaseNoticeRepository.findAll();
    }
}
