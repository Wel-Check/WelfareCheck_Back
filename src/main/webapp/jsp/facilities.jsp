<%@ page import="Welfare.WelfareCheck.domain.Facilitie.JDBCFacilitieRepository" %>
<%@ page import="Welfare.WelfareCheck.domain.Facilitie.BusanWelfareFacilitie" %>
<%@ page import="java.util.List" %>
<%@ page import="Welfare.WelfareCheck.domain.Facilitie.FacilitieRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JDBCFacilitieRepository jdbcFacilitieRepository = JDBCFacilitieRepository.getInstance();
    List<BusanWelfareFacilitie> facilities = jdbcFacilitieRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/index.html">메인</a>

    <table>
        <thead>
        <th>fno</th>
        <th>facilityName</th>
        <th>roadAddress</th>
        <th>tel</th>
        <th>facilityType</th>
        <th>gugun</th>
        <th>fixedNumber</th>
        <th>lon</th>
        <th>lat</th>
        <th>basicData</th>
        </thead>
        <tbody>
            <%
                for (BusanWelfareFacilitie busanWelfareFacilitie : facilities){
                    out.write("<tr>");
                    out.write(" <td>" + busanWelfareFacilitie.getFno() + "</td>");
                    out.write(" <td>" + busanWelfareFacilitie.getFacilityName() + "</td>");
                    out.write(" <td>" + busanWelfareFacilitie.getRoadAddress() + "</td>");
                    out.write(" <td>" + busanWelfareFacilitie.getTel() + "</td>");
                    out.write(" <td>" + busanWelfareFacilitie.getFacilityType() + "</td>");
                    out.write(" <td>" + busanWelfareFacilitie.getGugun() + "</td>");
                    out.write(" <td>" + busanWelfareFacilitie.getFixedNumber() + "</td>");
                    out.write(" <td>" + busanWelfareFacilitie.getLat() + "</td>");
                    out.write(" <td>" + busanWelfareFacilitie.getLon() + "</td>");
                    out.write(" <td>" + busanWelfareFacilitie.getBasicData() + "</td>");
                    out.write(" </tr>");
                }
            %>
        </tbody>
    </table>
</body>
</html>
