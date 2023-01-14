package team.world.best.backend.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.world.best.backend.common.code.ConflictExceptionCode;
import team.world.best.backend.common.exception.ConflictException;
import team.world.best.backend.member.domain.Member;
import team.world.best.backend.member.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) {
        validationEmail(member.getEmail()); // 중복 이메일 존재, 회원가입 불가능
        return memberRepository.save(member);
    }

    /**
     * 회원 이메일 중복 확인
     */
    public Boolean validationEmail(String email) {
        Member findMember = memberRepository.findByEmail(email);

        if (findMember != null) {
            throw new ConflictException(ConflictExceptionCode.E01_001);
        }
        return true;
    }

    /**
     * 회원 전체 조회
     */

    /**
     * 회원 탈퇴
     */
}
