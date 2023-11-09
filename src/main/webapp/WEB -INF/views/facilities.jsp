<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
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
    <c:forEach var="item" items="${facilitieList}">
        <tr>
            <td>${item.fon}</td>
            <td>${item.facilityName}</td>
            <td>${item.roadAddress}</td>
            <td>${item.facilityType}</td>
            <td>${item.gugun}</td>
            <td>${item.fixedNumber}</td>
            <td>${item.lon}</td>
            <td>${item.lat}</td>
            <td>${item.basicData}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
