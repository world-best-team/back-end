package team.world.best.backend.subscription.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SupplyType {

    PERMANENT(1, "영구임대"),
    NATIONAL(2, "국민임"),
    FIFTY(3, "50년임대"),
    PURCHASED(4, "매입임대"),
    DECADE(5, "10년임대"),
    DEMI_DECADE(6, "5년임대"),
    LONG_TERM(7, "장기전세"),
    CHARTER(8, "전세임대"),
    HAPPY(10, "행복주택"),
    PRIVATE(11, "공공지원민간임대");

    private final int code;
    private final String name;
}
