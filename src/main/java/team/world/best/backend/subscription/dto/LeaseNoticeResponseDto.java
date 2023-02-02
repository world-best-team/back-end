package team.world.best.backend.subscription.dto;

import team.world.best.backend.subscription.domain.HouseType;
import team.world.best.backend.subscription.domain.LeaseNotice;
import team.world.best.backend.subscription.domain.RegionType;
import team.world.best.backend.subscription.domain.SupplyType;

import java.time.LocalDateTime;

public class LeaseNoticeResponseDto {
    private String id;
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

    public LeaseNoticeResponseDto(LeaseNotice notice) {
        this.id = notice.getId();
        this.statusName = notice.getStatusName();
        this.noticeName = notice.getNoticeName();
        this.supplyInst = notice.getSupplyInst();
        this.houseType = notice.getHouseType();
        this.supplyType = notice.getSupplyType();
        this.recruitPubDate = notice.getRecruitPubDate();
        this.annWinDate = notice.getAnnWinDate();
        this.reference = notice.getReference();
        this.url = notice.getUrl();
        this.pcUrl = notice.getPcUrl();
        this.mobileUrl = notice.getMobileUrl();
        this.complexName = notice.getComplexName();
        this.regionType = notice.getRegionType();
        this.siggName = notice.getSiggName();
        this.fullAddress = notice.getFullAddress();
        this.roadAddress = notice.getRoadAddress();
        this.legalAddress = notice.getLegalAddress();
        this.heatMethodName = notice.getHeatMethodName();
        this.totalHousehold = notice.getTotalHousehold();
        this.supply = notice.getSupply();
        this.totalSupply = notice.getTotalSupply();
        this.deposit = notice.getDeposit();
        this.downPay = notice.getDownPay();
        this.secondPay = notice.getSecondPay();
        this.balancePay = notice.getBalancePay();
        this.rentPrice = notice.getRentPrice();
        this.beginDate = notice.getBeginDate();
        this.endDate = notice.getEndDate();
        this.views = notice.getViews();
    }
}
