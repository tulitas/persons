<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link href="<c:url value="/resources/css/palindrom.css"/>" rel="stylesheet">

    <title>Palindrom</title>
</head>
<body>
<header>
    <div class="name">Palindrom or not</div>
</header>
<section>
    <nav id="navbar">
        <ul>
            <li><a href="/">Top menu</a></li>
            <li><a onclick="location.href='/options/personsList'">Persons List</a></li>
            <li><a href="/palindrom">Palindrome</a></li>
            <li><a href="<c:url value="/logout"/>">Logout</a></li>
        </ul>
    </nav>

    <article>
        <form action="/palindrom/word" method="post">
            <label for="word" id="forLable">Enter a word</label><br>
            <textarea name="word" id="word" type="text" class="area" ></textarea><br>
            <input type="submit" value="Submit" class="button">
        </form>
    </article>
</section>
<footer>
    <p>Footer</p>
</footer>
</body>
</html>
