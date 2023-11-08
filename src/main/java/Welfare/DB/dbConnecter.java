package Welfare.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbConnecter {
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String user = "admin";
    String pw = "adminpw";
    Connection conn = null;
    PreparedStatement stmt = null;
    public dbConnecter(){

    }
    public PreparedStatement dbConnecting(String sql){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // connection으로 db와 연결 (객체 생성)
            conn = DriverManager.getConnection(url, user, pw);
            System.out.println(conn.isClosed()?"접속종료":"접속중");
            stmt = conn.prepareStatement(sql);
            System.out.println("접속 완료");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :" + cnfe);
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : " + sqle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }
    public PreparedStatement dbConnecting(String query, Long num, String lon, String roadAddress, String facilityName, String fixedNumber, String gugun, String tel, String basicData, String facilityType, String lat) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // connection으로 db와 연결 (객체 생성)
            conn = DriverManager.getConnection(url, user, pw);
            stmt = conn.prepareStatement(query);

            stmt.setString(1, String.valueOf(num));
            stmt.setString(2,lon);
            stmt.setString(3,roadAddress);
            stmt.setString(4,facilityName);
            stmt.setString(5,fixedNumber);
            stmt.setString(6,gugun);
            stmt.setString(7,tel);
            stmt.setString(8,basicData);
            stmt.setString(9,facilityType);
            stmt.setString(10,lat);


            System.out.println("접속 완료");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :" + cnfe);
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : " + sqle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }
    public void dbClose() {
        try {
            if (stmt != null)
                stmt.close();
        } catch (Exception e) {
            System.out.println(e + "=> dbClose fail");
        }
    }
}