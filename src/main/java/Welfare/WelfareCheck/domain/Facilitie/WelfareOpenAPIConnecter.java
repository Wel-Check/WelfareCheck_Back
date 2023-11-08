package Welfare.WelfareCheck.domain.Facilitie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class WelfareOpenAPIConnecter
{
    private static final StringBuilder _sb = new StringBuilder();
    List<BusanWelfareFacilitie> list = new ArrayList<>();
    private JDBCFacilitieRepository jdbcFacilitieRepository = JDBCFacilitieRepository.getInstance();
    int pageNo =208;
    int totalCount = 224;


     public WelfareOpenAPIConnecter() {
    }
    public void saveDB() throws JSONException {
        int index1;
        int index2;
        System.out.println("list add start");
        for (int i = pageNo; i <= totalCount; i++) {
            /*list.add(xmlToBusanWelfareFacilitie(getFacilitiesXml(String.valueOf(i), "1")));*/

            String tmp = getFacilitiesXml(String.valueOf(i),"1");
            BusanWelfareFacilitie busanWelfareFacilitie = new BusanWelfareFacilitie();

            busanWelfareFacilitie.setFno((long) i);
            index1 = tmp.indexOf("lon");
            tmp = tmp.substring(index1);
            index1 = tmp.indexOf(">");
            index2 = tmp.indexOf("<");
            busanWelfareFacilitie.setLon(tmp.substring(index1+1, index2)); //lon

            index1 = tmp.indexOf("road_address");
            tmp = tmp.substring(index1);
            index1 = tmp.indexOf(">");
            index2 = tmp.indexOf("<");
            busanWelfareFacilitie.setRoadAddress(tmp.substring(index1+1, index2)); //roadAddress

            index1 = tmp.indexOf("facility_name");
            tmp = tmp.substring(index1);
            index1 = tmp.indexOf(">");
            index2 = tmp.indexOf("<");
            busanWelfareFacilitie.setFacilityName(tmp.substring(index1+1, index2)); //facility_name

            index1 = tmp.indexOf("fixed_number");
            tmp = tmp.substring(index1);
            index1 = tmp.indexOf(">");
            index2 = tmp.indexOf("<");
            busanWelfareFacilitie.setFixedNumber(tmp.substring(index1+1, index2)); //      fixed_number

            index1 = tmp.indexOf("gugun");
            tmp = tmp.substring(index1);
            index1 = tmp.indexOf(">");
            index2 = tmp.indexOf("<");
            busanWelfareFacilitie.setGugun(tmp.substring(index1+1, index2)); //gugun

            index1 = tmp.indexOf("tel");
            tmp = tmp.substring(index1);
            index1 = tmp.indexOf(">");
            index2 = tmp.indexOf("<");
            busanWelfareFacilitie.setTel(tmp.substring(index1+1, index2)); //tel

            index1 = tmp.indexOf("basic_date");
            tmp = tmp.substring(index1);
            index1 = tmp.indexOf(">");
            index2 = tmp.indexOf("<");
            busanWelfareFacilitie.setBasicData(tmp.substring(index1+1, index2)); //basic_date

            index1 = tmp.indexOf("facility_type");
            tmp = tmp.substring(index1);
            index1 = tmp.indexOf(">");
            index2 = tmp.indexOf("<");
            busanWelfareFacilitie.setFacilityType(tmp.substring(index1+1, index2)); //facility_type

            index1 = tmp.indexOf("lat");
            tmp = tmp.substring(index1);
            index1 = tmp.indexOf(">");
            index2 = tmp.indexOf("<");
            busanWelfareFacilitie.setLat(tmp.substring(index1+1, index2)); //lat

            list.add(busanWelfareFacilitie);
            System.out.println(busanWelfareFacilitie);
        }
        System.out.println("list add end");
        //busanWelfareFacilitieSaveDB(); //저장하고 나면 중복때문에 추가 시 사용
    }

    /**
     * DB에 저장시키기
     */
    public void busanWelfareFacilitieSaveDB(){
        System.out.println("start save");
        for (BusanWelfareFacilitie busanWelfareFacilitie : list) {
            System.out.println(busanWelfareFacilitie);
            jdbcFacilitieRepository.save(busanWelfareFacilitie);
        }
        System.out.println("end save");
    }
    public static String getFacilitiesXml(String pageNo, String numOfRows) {
        _sb.setLength(0);
        var urlBuilder = new StringBuilder("http://apis.data.go.kr/6260000/BusanDisabledFacService/getTblDisabledFac");
        urlBuilder.append("?serviceKey=73iDZKFpqjBQWNBKlP5Ii5tFs3l%2BLY7tBRc70SqzSxPxjD3DDUBuLGLytfJeR%2FGiII26o74%2BvwsuDDSVeoYW4w%3D%3D");
        urlBuilder.append("&pageNo=").append(pageNo);
        urlBuilder.append("&numOfRows=").append(numOfRows);
        urlBuilder.append("&dataType=" + "json");

        try {
            var url = new URL(urlBuilder.toString());
            //System.out.println(url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");

            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            String line;
            while ((line = rd.readLine()) != null) {
                _sb.append(line);
            }
            rd.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();

            _sb.setLength(0);
        }
        //System.out.println(_sb);
        //System.out.println(urlBuilder.toString());
        return _sb.toString();
    }

}