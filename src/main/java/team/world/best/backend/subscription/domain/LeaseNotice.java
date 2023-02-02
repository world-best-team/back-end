package team.world.best.backend.subscription.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class LeaseNotice {
    @Id
    private String id; // 공고 id
    private String beforeId; // 이전 공고 id
    private Long houseSn; // 주택 일련 번호
    private String statusName; // 공고 상태
    private String noticeName; // 공고명
    private String supplyInst; // 공급 기관
    private HouseType houseType; // 주택 유형
    private SupplyType supplyType; // 공급 유형
    private LocalDateTime recruitPubDate; // 모집 공고 일정
    private LocalDateTime annWinDate; // 당첨자 발표 일정
    private String reference; // 문의처
    private String url;
    private String pcUrl;
    private String mobileUrl;
    private String complexName; // 단지명
    private RegionType regionType; // 지역
    private String siggName; // 시군구
    private String fullAddress; // 전체 주소
    private String roadAddress; // 도로명 주소
    private String legalAddress; // 법정동명 주소
    private String pnu; // PNU

    private String heatMethodName; // 난방 방식명
    private String totalHousehold; // 총 세대수
    private int supply; // 공급 호수 (전세임대 해당)
    private int totalSupply; // 공급 호수

    private Long deposit; // 최소임대보증금
    private Long downPay; // 최소계약금
    private Long secondPay; // 최소중도금
    private Long balancePay; // 최소잔금
    private Long rentPrice; // 월 임대료

    private LocalDateTime beginDate; // 공고모집일
    private LocalDateTime endDate; // 공고마감일
    private int views; // 조회 수

    public void view() {
        this.views ++;
    }
}


