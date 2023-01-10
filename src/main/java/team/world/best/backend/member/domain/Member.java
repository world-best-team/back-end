package team.world.best.backend.member.domain;

import jakarta.persistence.*;
import lombok.Getter;
import team.world.best.backend.community.domain.Comment;
import team.world.best.backend.community.domain.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String email;
    private String password;
    private Role role;
    private String alias;
    @Enumerated(EnumType.STRING)
    private MemberStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private LocalDateTime lastIn;
    private Boolean submit;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();
}
