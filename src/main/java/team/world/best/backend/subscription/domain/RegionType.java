package team.world.best.backend.subscription.domain;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RegionType {

    SEOUL(11, "서울특별시"),
    BUSAN(26, "부산광역시"),
    DAEGU(27, "대구광역시"),
    INCHOEN(28, "인천광역시"),
    GWANGJU(29, "광주광역시"),
    DAEJEON(30, "대전광역시"),
    ULSAN(31, "울산광역시"),
    SEJONG(36, "세종특별자치시"),
    GYEONGGI(41, "경기도"),
    JEJU(50, "제주특별자치도");
    private final int code;
    private final String name;
}
