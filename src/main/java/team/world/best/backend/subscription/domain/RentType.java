package team.world.best.backend.subscription.domain;


// 월 임대료 구분

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RentType {

    UNDER(1, "5만원 미만"),
    UNDER_10(2, "5~10만원 미만"),
    UNDER_20(3, "10~20만원 미만"),
    UNDER_30(4, "20~30만원 미만"),
    OVER(5, "30만원 이상");

    private final int code;
    private final String name;
}
