package team.world.best.backend.community.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String authorEmail;
}
