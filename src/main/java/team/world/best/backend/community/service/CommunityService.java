package team.world.best.backend.community.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.world.best.backend.community.domain.Comment;
import team.world.best.backend.community.domain.Post;
import team.world.best.backend.community.repository.CommentRepository;
import team.world.best.backend.community.repository.PostRepository;
import team.world.best.backend.member.domain.Member;
import team.world.best.backend.member.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommunityService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Long post(String title, String content, String authorEmail) {
        // Entity 조회
        Member findMember = memberRepository.findByEmail(authorEmail);

        // 생성 메서드 호출
        Post newPost = Post.createPost(title, content, findMember);

        // repository
        Long saveId = postRepository.save(newPost);

        return saveId;
    }

    @Transactional
    public Long comment(Long postId, String authorEmail, String content) {
        // Entity 조회
        Post findPost = postRepository.findById(postId);
        Member findMember = memberRepository.findByEmail(authorEmail);

        // 생성메서드 호출
        Comment newComment = Comment.createComment(content, findMember, findPost);

        // repository
        Long saveId = commentRepository.save(newComment);

        return saveId;
    }

    @Transactional
    public Long updatePost(Long id, String authorEmail, String title, String content) {
        // 수정 요청한 게시글의 email과 로그인 되어있는 멤버의 email이 같아야함
        Post findPost = postRepository.findById(id);
        findPost.update(title, content);
        return findPost.getId();
    }

    @Transactional
    public Post findPostById(Long id) {
        Post findPost = postRepository.findById(id);
        findPost.view();
        return findPost;
    }

    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    public Comment findCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findComments() {
        return commentRepository.findAll();
    }

    public List<Comment> findCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

}
