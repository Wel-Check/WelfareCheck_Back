package Welfare.WelfareCheck.domain.Facilitie;

import Welfare.DB.dbConnecter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCFacilitieRepository implements FacilitieRepository {
    dbConnecter dbc = new dbConnecter();
    PreparedStatement stmt = null;
    ResultSet result = null;
    private static final JDBCFacilitieRepository instance = new JDBCFacilitieRepository();
    List<BusanWelfareFacilitie> list =null;
    BusanWelfareFacilitie busanWelfareFacilitie = null;
    String fno = null;
    String lon = null;
    String roadAddress = null;
    String facilityName = null;
    String fixedNumber = null;
    String gugun = null;
    String tel = null;
    String basicData = null;
    String facilityType = null;
    String lat = null;
    public static JDBCFacilitieRepository getInstance() {
        return instance;
    }
    private JDBCFacilitieRepository() {
    }
    @Override
    public BusanWelfareFacilitie save(BusanWelfareFacilitie facilitie) {
        System.out.println("[facilitie save] - start");
        Long num = facilitie.getFno();
        lon = facilitie.getLon();
        roadAddress = facilitie.getRoadAddress();
        facilityName = facilitie.getFacilityName();
        fixedNumber = facilitie.getFixedNumber();
        gugun = facilitie.getGugun();
        tel = facilitie.getTel();
        basicData = facilitie.getBasicData();
        facilityType = facilitie.getFacilityType();
        lat = facilitie.getLat();

        try {
            String query = "INSERT INTO FACILITIE (FNO,LON,ROADADDRESS,FACILITYNAME,FIXEDNUMBER,GUGUN,TEL,BASICDATA,FACILITYTYPE,LAT) values (?,?,?,?,?,?,?,?,?,?)";
            stmt = dbc.dbConnecting(query,num,lon,roadAddress,facilityName,fixedNumber,gugun,tel,basicData,facilityType,lat);
            result = stmt.executeQuery();
        } catch (Exception e) {
            System.out.println("시설 save 실패" + e.toString());
        }finally {
            System.out.println("[facilitie save] - end");
            dbc.dbClose();
        }
        return facilitie;
    }

    @Override
    public BusanWelfareFacilitie findByNum(String num) {
        busanWelfareFacilitie = null;
        lon = null;
        roadAddress = null;
        facilityName = null;
        fixedNumber = null;
        gugun = null;
        tel = null;
        basicData = null;
        facilityType = null;
        lat = null;

        fno = num;

        try {
            System.out.println("[facilitie findByNum] - start");
            //String query = "SELECT FNO,LON,ROADADDRESS,FACILITYNAME,FIXEDNUMBER,GUGUN,TEL,BASICDATA,FACILITYTYPE,LAT FROM FACILITIE WHERE FNO ='" + fno + "'";
            String query = "SELECT * FROM FACILITIE WHERE FNO ='" + fno + "'";
            stmt = dbc.dbConnecting(query);
            result = stmt.executeQuery();
            while(result.next()) {
                lon = result.getString("lon");
                roadAddress = result.getString("roadaddress");
                facilityName = result.getString("facilityName");
                fixedNumber = result.getString("fixedNumber");
                gugun = result.getString("gugun");
                tel = result.getString("tel");
                basicData = result.getString("basicData");
                facilityType = result.getString("facilityType");
                lat = result.getString("lat");
                busanWelfareFacilitie = new BusanWelfareFacilitie(fno,lon, roadAddress, facilityName, fixedNumber, gugun, tel, basicData, facilityType, lat);
            }
        }catch(Exception e) {
            System.out.println("시설 조회 실패" + e.toString());
        }finally {
            System.out.println("[facilitie findByNum] - end");
            dbc.dbClose();
        }
        return  busanWelfareFacilitie;
    }

    @Override
    public  List<BusanWelfareFacilitie> facilityNameSearch(String searchword) {
        System.out.println(searchword);
        list = new ArrayList<>();
        busanWelfareFacilitie = null;
        fno = null;
        lon = null;
        roadAddress = null;
        facilityName = null;
        fixedNumber = null;
        gugun = null;
        tel = null;
        basicData = null;
        facilityType = null;
        lat = null;
        try {
            System.out.println("[facilitie facilitySearch] - start");
            String query = "SELECT * FROM FACILITIE WHERE FACILITYNAME LIKE '%" + searchword + "%'";
            stmt = dbc.dbConnecting(query);
            result = stmt.executeQuery(query);
            while (result.next()) {
                fno = result.getString("fno");
                lon = result.getString("lon");
                roadAddress = result.getString("roadaddress");
                facilityName = result.getString("facilityName");
                fixedNumber = result.getString("fixedNumber");
                gugun = result.getString("gugun");
                tel = result.getString("tel");
                basicData = result.getString("basicData");
                facilityType = result.getString("facilityType");
                lat = result.getString("lat");
                busanWelfareFacilitie = new BusanWelfareFacilitie(fno,lon, roadAddress, facilityName, fixedNumber, gugun, tel, basicData, facilityType, lat);
                System.out.println(busanWelfareFacilitie);
                list.add(busanWelfareFacilitie);
            }
        } catch(Exception e) {
            System.out.println("시설 검색 실패" + e.toString());
        } finally {
            System.out.println(list);
            System.out.println("[facilitie facilitySearch] - end");
            dbc.dbClose();
        }
        return list;
    }

    @Override
    public List<BusanWelfareFacilitie>  findAll() {
        list = new ArrayList<>();
        busanWelfareFacilitie = null;
        fno = null;
        lon = null;
        roadAddress = null;
        facilityName = null;
        fixedNumber = null;
        gugun = null;
        tel = null;
        basicData = null;
        facilityType = null;
        lat = null;

        System.out.println("[facilitie findAll] - start");
        try {
            String query = "SELECT * FROM FACILITIE";
            stmt = dbc.dbConnecting(query);
            result = stmt.executeQuery();
            while (result.next()) {
                fno = result.getString("fno");
                lon = result.getString("lon");
                roadAddress = result.getString("roadaddress");
                facilityName = result.getString("facilityName");
                fixedNumber = result.getString("fixedNumber");
                gugun = result.getString("gugun");
                tel = result.getString("tel");
                basicData = result.getString("basicData");
                facilityType = result.getString("facilityType");
                lat = result.getString("lat");
                busanWelfareFacilitie = new BusanWelfareFacilitie(fno,lon, roadAddress, facilityName, fixedNumber, gugun, tel, basicData, facilityType, lat);
                list.add(busanWelfareFacilitie);
            }
        } catch (SQLException e) {
            System.out.println("시설 검색 실패" + e.toString());
        } finally {
            System.out.println("[facilitie findAll] - end");
            dbc.dbClose();
        }
        return list;
    }
}
