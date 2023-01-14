package team.world.best.backend.community.domain;

import jakarta.persistence.*;
import lombok.Getter;
import team.world.best.backend.member.domain.Member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String content;
    private int userLike;
    private int userDislike;
    private int views;
    @Enumerated(EnumType.STRING)
    private PostStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime deletedAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 작성자

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    /**
     * 연관관계 메서드
     */
    public void setMember(Member member) {
        this.member = member;
        member.getPosts().add(this);
    }

    /**
     * 생성 메서드
     */
    public static Post createPost(String title, String content, Member member) {
        Post post = new Post();
        post.post(title, content);
        post.setMember(member);
        return post;
    }

    /**
     * 비지니스 로직
     */

    public void post(String title, String content){
        this.title = title;
        this.content = content;
        this.userLike = 0;
        this.userDislike = 0;
        this.views = 0;
        this.status = PostStatus.CREATED;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
        this.modifiedAt = LocalDateTime.now();
    }

    public void like() {
        this.userLike ++;
    }

    public void dislike() {
        this.userDislike ++;
    }

    public void view() {
        this.views ++;
    }

}
