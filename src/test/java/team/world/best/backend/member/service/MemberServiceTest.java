package team.world.best.backend.member.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team.world.best.backend.common.exception.ConflictException;
import team.world.best.backend.member.domain.Member;
import team.world.best.backend.member.domain.Role;
import team.world.best.backend.member.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입 () throws Exception {
        //given
        Member member = new Member();
        member.required("test@example.com", "1234", Role.USER, "testUser");

        //when
        Long joinedMemberId = memberService.join(member);

        //then
        Member findMember = memberRepository.findById(joinedMemberId);
        assertEquals(findMember.getId(), member.getId());
    }

    @Test
    public void 이메일_중복확인_예외() throws Exception {
        //given
        String testEmail = "test@example.com";
        Member member = new Member();
        member.required(testEmail, "1234", Role.USER, "testUser");

        //when
        memberService.join(member);

        //then
        assertThrows(ConflictException.class, () -> {
            // 이메일
            memberService.validationEmail(testEmail);
        });
    }

    @Test
    public void 이메일_중복확인_통과() throws Exception {
        //given
        String testEmail = "test@example.com";

        //when
        Boolean validationResult = memberService.validationEmail(testEmail);

        //then
        assertEquals(Boolean.TRUE, validationResult);
    }
}