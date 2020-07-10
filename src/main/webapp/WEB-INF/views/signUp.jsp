<%--
  Created by IntelliJ IDEA.
  User: SergejK
  Date: 09-Jul-20
  Time: 07:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}options/create" method="post">

        <label for="login">Login</label>
        <input type="text" name="login" id="login"><br>

        <label for="password">Password</label>
        <input type="text" name="password" id="password"><br>

        <label for="full_name">Name</label>
        <input type="text" name="fullName" id="full_name"><br>

        <label for="age">Age</label>
        <input type="text" name="age" id="age"><br>

        <label for="reg_date">Time</label>
        <input type="datetime-local" name="regDate" id="reg_date"><br>

        <p>
            <button class="add_button"> Pievienot</button>
        </p>

    </form>
</div>
</body>
</html>
