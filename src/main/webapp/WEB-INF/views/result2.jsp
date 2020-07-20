<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SergejK
  Date: 28-May-20
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .item1 {
            font-family: "Droid Serif", fantasy ;
            font-optical-sizing: auto;
            font-size: 30px;
            text-shadow: #33ADFF 2px 5px;
            text-align: center;
        }

        body {
            background-color: #aabcfe;
        }
    </style>
    <title>Result</title>
</head>
<body>
<a href="/">Top page</a>
<div class="item1">
    <c:out value="${numString}"/>
</div>
</body>
</html>
