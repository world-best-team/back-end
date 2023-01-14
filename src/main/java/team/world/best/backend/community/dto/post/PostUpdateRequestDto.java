package team.world.best.backend.community.dto.post;

import lombok.Getter;

@Getter
public class PostUpdateRequestDto {

    private String authorEmail;
    private String title;
    private String content;
}
