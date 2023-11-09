<%@ page import="Welfare.WelfareCheck.domain.Facilitie.JDBCFacilitieRepository" %>
<%@ page import="Welfare.WelfareCheck.domain.Facilitie.BusanWelfareFacilitie" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JDBCFacilitieRepository jdbcFacilitieRepository = JDBCFacilitieRepository.getInstance();

    String searchword = request.getParameter("searchword");
    System.out.println(searchword);
    List<BusanWelfareFacilitie> facilities = jdbcFacilitieRepository.facilityNameSearch(searchword);
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
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
<%
    if(facilities.size() == 0){
        out.write("존재하지 않음");
    }
%>
<a href="/index.html">메인</a>
</body>
</html>
