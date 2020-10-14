<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body {
        background: url("https://st.depositphotos.com/1483427/3042/i/950/depositphotos_30422869-stock-photo-letters-background.jpg");
        background-size: 100%;
    }
    section:after {
        content: "";
        display: table;
        clear: both;
    }
    article {
        float: left;
        padding: 20px;
        width: 70%;
        background-color: #f1f1f1;
        height: 300px; /* only for demonstration, should be removed */
    }

    * {
        box-sizing: border-box;
    }

    body {
        font-family: Arial, Helvetica, sans-serif;
    }

    nav {
        float: left;
        width: 10%;
        height: 100px; /* only for demonstration, should be removed */
        background: #ccc;
        padding: 20px;
    }

    nav ul {
        list-style-type: none;
        padding: 0;
    }

    section:after {
        content: "";
        display: table;
        clear: both;
    }

    /*header {*/
    /*background-color: cadetblue;*/
    /*padding: 30px;*/
    /*}*/

    .name {
        text-align: center;
        color: #33ADFF;
        font-size: 50px;
        text-shadow: 4px 2px 3px #75ff87, 0 0 1em #ffcce9;

        font-family: Dialog, serif;
        padding: 30px;
        background: rgba(2%, 2%, 2%, 0.3);
    }

    /*menu*/
    #navbar {
        margin: 0;
        padding: 0;
        list-style-type: none;
        width: 200px;
    }

    #navbar li {
        border-left: 10px solid #666;
        border-bottom: 1px solid #666;
    }

    #navbar a {
        background-color: #949494;
        color: #fff;
        padding: 5px;
        text-decoration: none;
        font-weight: bold;
        border-left: 5px solid #33ADFF;
        display: block;
    }

    #navbar a:hover {
        background-color: #666;
        border-left: 5px solid #3333FF;
    }

    #forLable {
        margin-left: 45%;
        margin-top: 50%;
        font-size: 35px;
        font-family: Bradley, Hand, cursive;
        text-shadow: 4px 2px 3px #33ADFF, 0 0 1em #3333FF;

    }
    .area {
        margin-left: 46%;
        margin-top: 40px;
    }
    .button {
        margin-left: 51%;
        margin-top: 55px;
    }
    /**/
</style>
<head>

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
