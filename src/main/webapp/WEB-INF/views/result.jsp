<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <link href="<c:url value="/resources/css/result.css"/>" rel="stylesheet">

    <meta charset="UTF-8">
    <title>Result</title>
</head>
<body>
<header>
    <div class="name">Result</div>
</header>
<section>

    <nav id="navbar">
        <ul>
            <li><a href="/">Top menu</a></li>
            <li><a onclick="location.href='/options/personsList'">Persons List</a></li>
            <li><a href="${pageContext.request.contextPath}/numberToStringX">Number to string</a></li>
        </ul>
    </nav>

    <article>
        <div id="aa">
            <div id="text">
                Word "<c:out value="${result}"/>" <c:out value="${palindromChek}"/>
            </div>
        </div>

    </article>
</section>
<footer>

</footer>
</body>
</html>
