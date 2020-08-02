<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
    <title>Login Page</title>


</head>
<body>


<div class="login">
    <h1>Login</h1>
    <form  name="login" action="${pageContext.request.contextPath}login/process" method='POST'>
        <input type="text" name="login" placeholder="Login Name" required="required"/>
        <input type="password" name="password" placeholder="Password" required="required"/>
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    </form>
    <button onclick="location.href='/registration'" class="btn-primary btn-block btn-large">Registration</button>
</div>
</body>
</html>
