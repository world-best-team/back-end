package team.world.best.backend.community.dto;

import lombok.Getter;

@Getter
public class PostSaveResponseDto {
    private Long id;

    public PostSaveResponseDto(Long id) {
        this.id = id;
    }
}
