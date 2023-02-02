package team.world.best.backend.subscription.dto;

import team.world.best.backend.common.dto.DataResponse;

import java.util.List;

public class LeaseNoticeListResponseDto extends DataResponse {

    private int count;
    public LeaseNoticeListResponseDto(List data) {
        super(data);
        this.count = data.size();
    }

}
