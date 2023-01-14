package team.world.best.backend.community.dto.post;

import lombok.Getter;
import team.world.best.backend.community.domain.Post;
import team.world.best.backend.community.dto.comment.CommentResponseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostListResponseDto {
    private Long postId;
    private String title;
    private String content;
    private int userLike;
    private int userDislike;
    private int views;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String authorEmail;
    private String authorAlias;
    private int commentsCount;

    public PostListResponseDto(Post post) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.userLike = post.getUserLike();
        this.userDislike = post.getUserDislike();
        this.views = post.getViews();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.authorEmail = post.getMember().getEmail();
        this.authorAlias = post.getMember().getAlias();
        this.commentsCount = post.getComments().size();
    }
}
