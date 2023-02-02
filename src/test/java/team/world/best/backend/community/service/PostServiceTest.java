package team.world.best.backend.community.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team.world.best.backend.community.domain.Post;
import team.world.best.backend.member.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostServiceTest {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CommunityService postService;
    @Test
    public void 게시글_작성() throws Exception {
        //given
        String testTitle = "testTitle";
        String testContent = "testContent";
        String testAuthorEmail = "test@example.com";

        //when
        Long postId = postService.post(testTitle, testContent, testAuthorEmail);

        //then
        Post findPost = postService.findPostById(postId);
        assertEquals(postId, findPost.getId());

    }
}