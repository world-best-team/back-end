package team.world.best.backend.community.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import team.world.best.backend.community.domain.Comment;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponseDto {
    private String authorAlias;
    private String authorEmail;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.authorAlias = comment.getMember().getAlias();
        this.authorEmail = comment.getMember().getEmail();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
