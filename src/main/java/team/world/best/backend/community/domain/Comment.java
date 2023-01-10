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
}
