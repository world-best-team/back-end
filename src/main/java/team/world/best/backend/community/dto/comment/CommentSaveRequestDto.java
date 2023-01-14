package team.world.best.backend.community.dto.comment;

import lombok.Getter;

@Getter
public class CommentSaveRequestDto {
    private Long postId;
    private String authorEmail;
    private String content;
}
