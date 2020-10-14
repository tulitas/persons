<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/registration.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/JS/jquery.1.10.2.min" />"></script>
    <script src="<c:url value="/resources/JS/registration.js"/>"></script>
    <title>Sign Up</title>
</head>
<body>
<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>


<nav>
    <a href="${pageContext.request.contextPath}/">
        <span>HOME</span>
    </a>
    <a href="#!">
        <span>A</span>
    </a>
    <a href="#!">
        <span>C</span>
    </a>
    <a href="#!">
        <span>F</span>
    </a>
</nav>


<div class="wrapper">
    <h1>Register For An Account</h1>
    <p>To sign-up for a free basic account please provide us with some basic information using
        the contact form below. Please use valid credentials.</p>

    <form class="form" method="post" action="${pageContext.request.contextPath}options/create">

        <input type="text" name="login" id="login" placeholder="Login Name"><br>
        <input type="text" class="name" placeholder="Name" autocomplete="off" id="name" name="fullName">
        <input type="email" class="email" placeholder="Email" id="email" autocomplete="off" name="email">
        <input type="password" class="password" placeholder="password" id="password" autocomplete="off" name="password">
        <input type="text" name="dateOfBirth" id="dateofbirth" placeholder="format: DD.MM.YY" class="name">

        <select name="gender" id="gender" class="select-css" style="width:200px;">
            <option value="0">Male</option>
            <option value="1">Female</option>
        </select>

        <input type="submit" class="submit" value="Register">
    </form>
</div>
<p class="optimize">
    Optimized for Chrome & Firefox!
</p>


</body>

</html>
