package team.world.best.backend.subscription.domain;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum HouseType {

    APARTMENT(11, "아파트"),
    ROW(12, "연립주택"),
    MULTIPLEX(13, "다세대주택"),
    DETACHED(14, "단독주택"),
    OFFICETEL(15, "오피스텔"),
    MULTIHOUSEHOLD(16, "다가구주택");

    private final int code;
    private final String name;
}
