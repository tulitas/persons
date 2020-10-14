<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            background-color: #cccccc;
        }

        * {
            box-sizing: border-box;
        }

        header {
            background-color: #666666;
            padding: 30px;
            text-align: center;
            font-size: 35px;
            color: white;
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

        section:after {
            content: "";
            display: table;
            clear: both;
        }

        footer {
            background-color: #777;
            padding: 10px;
            text-align: center;
            color: white;
        }

        @media (max-width: 600px) {
            nav, article {
                width: 100%;
                height: auto;
            }
        }

        .text {
            position: relative;
            top: 40px;
            left: 50px;
            background-color: rgba(49, 99, 49, 0.57);
            outline: none;
            border-radius: 8px;
            height: 30px;
            /*width: 40px;*/
            font-size: 25px;
            color: #75ff87;
        }

        .button1 {
            /*position: relative;*/
            /*left: 150px;*/
            /*top: 50px;*/
            /*outline: none;*/
            background-size: 20px, 20px;
            background: url("https://lh3.googleusercontent.com/proxy/LdHnrGK8uG30l9Gov3rtFLp82qoGUnXbaomOu-K4B7AdEiX2tQukt837-rFUaRqHGoyoYZb5kNQUs0ES4LWnijw2nTq5D2RaKlBL2kE6K6lT8gYmWgEql0FjXA");
        }

    </style>
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
