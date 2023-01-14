package team.world.best.backend.community.dto.post;

import lombok.Getter;
import team.world.best.backend.common.dto.DataResponse;

import java.util.List;

@Getter
public class PostResponseWithCount extends DataResponse {
    private int count;

    public PostResponseWithCount(List data) {
        super(data);
        this.count = data.size();
    }
}