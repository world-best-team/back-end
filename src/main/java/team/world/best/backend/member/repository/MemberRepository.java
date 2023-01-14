package team.world.best.backend.member.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team.world.best.backend.member.domain.Member;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findById(Long memberId) {
        return em.find(Member.class, memberId);
    }

    public Member findByEmail(String email) {
        return em.createQuery(
                "select m from Member m" +
                " where m.email = :email", Member.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    public List<Member> findAll() {
        return em.createQuery(
                        "select m from Member m",
                        Member.class)
                .getResultList();
    }
}
