package team.world.best.backend.community.domain;

import jakarta.persistence.*;
import lombok.Getter;
import team.world.best.backend.member.domain.Member;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;
    private String content;
    private int userLike;
    private int userDislike;
    @Enumerated(EnumType.STRING)
    private CommentStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime deletedAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 작성자

    /**
     * 연관관계 메서드
     */
    public void setMember(Member member){
        this.member = member;
        member.getComments().add(this);
    }

    public void setPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }

    /**
     * 생성 메서드
     */

    public static Comment createComment(String content, Member member, Post post) {
        Comment comment = new Comment();
        comment.comment(content);
        comment.setMember(member);
        comment.setPost(post);
        return comment;
    }

    /**
     * 비지니스 로직
     */

    public void comment(String content) {
        this.content = content;
        this.userLike = 0;
        this.userDislike = 0;
        this.status = CommentStatus.CREATED;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public void update() {

    }
}
