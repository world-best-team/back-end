package team.world.best.backend.community.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostResponseDto {
    private String title;
    private String content;
    private int userLike;
    private int userDislike;
    private int views;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String authorEmail;
    private String authorAlias;
//    private List<CommentResponseDto> comments;

    public PostResponseDto(String title, String content, int userLike, int userDislike, int views, LocalDateTime createdAt, LocalDateTime modifiedAt, String authorEmail, String authorAlias) {
        this.title = title;
        this.content = content;
        this.userLike = userLike;
        this.userDislike = userDislike;
        this.views = views;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.authorEmail = authorEmail;
        this.authorAlias = authorAlias;
//        this.comments = comments;
    }
}
