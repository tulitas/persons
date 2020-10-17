<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/numberToString.css"/>" rel="stylesheet">

    <title>Number to string</title>
</head>
<body>
<header>
    Convert number to string
</header>

<section>
    <nav>
        <ul>
            <li><a href="/">top page</a></li>
            <li><a onclick="location.href='/options/personsList'">persons list</a></li>
           <li> <a href="/palindrom">palindrom</a></li>
        </ul>
    </nav>
    <article>
        <form action="${pageContext.request.contextPath}/numberConvert" method="post">
            <label for="num">Enter digits from 0 up to 99</label><br>
            <input class="text" id="num" name="num" pattern="{0-99}" title="only numbers"/>
            <input type="submit" value="Submit" class="button">
        </form>
    </article>
</section>
<button class="mainButtons" onclick="location.href='/options/personsList'">Persons List</button>

<footer>

</footer>
</body>
</html>
