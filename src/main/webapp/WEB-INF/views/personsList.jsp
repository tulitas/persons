<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SergejK
  Date: 11-Jul-20
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="refresh" content="10"/>
</head>
<body>

<table style="word-wrap: break-word" border="7">
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Password</th>
        <th>Full Name</th>
        <th>Age</th>
        <th>Registration Date</th>

    </tr>

    <c:forEach var="personsForm" items="${personsList}">

        <tr>
            <td width="75">${personsForm.id}</td>

            <td width="50">${personsForm.login}</td>
            <td width="50">${personsForm.password}</td>
            <td width="50">${personsForm.fullName}</td>
            <td width="50">${personsForm.age}</td>
            <td width="50">${personsForm.regDate}</td>
            <td width="50"><a href="/options/delete${personsForm.id}">Delete</a></td>
            <td width="50"><a class="delete" href="/options/edit${personsForm.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<font face="verdana" size="2">
    Current Time :<%= new java.util.Date() %>
</font>
</body>
</html>
