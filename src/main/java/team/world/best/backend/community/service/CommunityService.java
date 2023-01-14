package team.world.best.backend.community.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.world.best.backend.community.domain.Post;
import team.world.best.backend.community.repository.PostRepository;
import team.world.best.backend.member.domain.Member;
import team.world.best.backend.member.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long post(String title, String content, String authorEmail){
        Member findMember = memberRepository.findByEmail(authorEmail);
        Post newPost = new Post();
        newPost.posting(title, content, findMember);
        Long saveId = postRepository.save(newPost);

        return saveId;
    }

    @Transactional
    public Long update(Long id, String authorEmail, String title, String content){
        // 수정 요청한 게시글의 email과 로그인 되어있는 멤버의 email이 같아야함
        Post findPost = postRepository.findById(id);
        findPost.update(title, content);
        return findPost.getId();
    }


    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findPosts() {
        return postRepository.findAll();
    }

}
