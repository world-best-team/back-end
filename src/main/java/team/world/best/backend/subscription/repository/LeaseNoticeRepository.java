package team.world.best.backend.subscription.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.world.best.backend.subscription.domain.LeaseNotice;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LeaseNoticeRepository {
    private final EntityManager em;

    public String save(LeaseNotice leaseNotice) {
        em.persist(leaseNotice);
        return leaseNotice.getId();
    }

    public List<LeaseNotice> findAll() {
        return em.createQuery("select l from LeaseNotice as l", LeaseNotice.class)
                .getResultList();
    }

    public LeaseNotice findById(String id) {
        return em.find(LeaseNotice.class, id);
    }

}
