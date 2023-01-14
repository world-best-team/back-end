package team.world.best.backend.community.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String authorEmail;
}
