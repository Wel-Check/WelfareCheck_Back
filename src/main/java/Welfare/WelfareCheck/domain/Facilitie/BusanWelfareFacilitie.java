package Welfare.WelfareCheck.domain.Facilitie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusanWelfareFacilitie {
    private Long fno;
    private String lon;          //경도
    private String roadAddress;  //도로명주소
    private String facilityName; //시설명
    private String fixedNumber;  //정원
    private String gugun;        //구군명
    private String tel;          //전화번호
    private String basicData;    //데이터기준일자
    private String facilityType; //시설유형
    private String lat;          //위도

    public BusanWelfareFacilitie() {
    }

    public BusanWelfareFacilitie(String fno, String lon, String roadAddress, String facilityName, String fixedNumber, String gugun, String tel, String basicData, String facilityType, String lat) {
        this.fno = Long.valueOf(fno);
        this.lon = lon;
        this.roadAddress = roadAddress;
        this.facilityName = facilityName;
        this.fixedNumber = fixedNumber;
        this.gugun = gugun;
        this.tel = tel;
        this.basicData = basicData;
        this.facilityType = facilityType;
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "BusanWelfareFacilitie{" +
                "fno=" + fno +
                ", lon='" + lon + '\'' +
                ", roadAddress='" + roadAddress + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", fixedNumber='" + fixedNumber + '\'' +
                ", gugun='" + gugun + '\'' +
                ", tel='" + tel + '\'' +
                ", basicData='" + basicData + '\'' +
                ", facilityType='" + facilityType + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}
