
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/welcome.css"/>" rel="stylesheet">
    <title>Welcome</title>
</head>
<sec:authorize access="isAuthenticated()">
    <body>
    <a href="<c:url value="/logout"/>">Logout</a>
    Welcome.
    You can use<p>
    <button onclick="location.href='/options/personsList'">Persons List</button>
    <p>
        <button onclick="location.href='/palindrom'">Palindrom</button>
        <button onclick="location.href='/numberToStringX'">Number To String</button>

    </body>
</sec:authorize>
</html>
