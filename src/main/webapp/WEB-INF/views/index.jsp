<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SergejK
  Date: 09-Jul-20
  Time: 07:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <title>Persons Note</title>
</head>
<body style="background-color: cadetblue">
<div  id="buttonBox">
    <div >
        <button class="mainButtons" onclick="location.href='/signIn'">Sign In</button>
        <button class="mainButtons" onclick="location.href='/signUp'">Sign Up</button>
        <button class="mainButtons" onclick="location.href='/options/personsList'">Persons List</button>
    </div>
</div>
</body>
</html>
