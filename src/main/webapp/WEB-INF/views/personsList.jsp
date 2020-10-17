<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/personsList.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/JS/personsList.js"/>"></script>

    <meta http-equiv="refresh" content="20"/>
    <style>

    </style>
</head>

<body style="background-color: #f4e6e8">

<sec:authorize access="isAuthenticated()">
    <button onclick="sortTableByLogin()">Sort by login</button>
    <button onclick="sortTableByLoginByName()">Sort by name</button>
    <button onclick="sortTableByAge()">Sort by age</button>
    <button onclick="location.href='/palindrom'">Palindrom</button>
    <button onclick="location.href='/numberToStringX'">Number To String</button><br><br>
    <h2>Page have autorefresh after 20 sec</h2>
    <label for="search-text">You can make a search about any dates from data table</label><br>
    <input class="form-control" type="text" placeholder="Write any dates for search" id="search-text" onkeyup="tableSearch()">
    <br>
    <table id="myTable">
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Full Name</th>
            <th>Date Of Birth</th>
            <th>Gender</th>
            <th colspan="2">Action</th>


        </tr>

        <c:forEach var="personsForm" items="${personsList}">

            <tr>
                <td width="75">${personsForm.id}</td>
                <td width="50">${personsForm.login}</td>
                <td width="50">${personsForm.fullName}</td>
                <td width="50">${personsForm.dateOfBirth}</td>
                <td width="50">${personsForm.gender}</td>
                <td width="50"><a href="/options/delete${personsForm.id}">Delete</a></td>
                <td width="50"><a class="delete" href="/options/edit${personsForm.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="location.href='/options/csv'">Export CSV</button>
    <button onclick="location.href='/options/uploadCsv'">Import CSV</button>
    <br>

    <a href="<c:url value="/logout"/>">Logout</a>

</sec:authorize>

<a href="${pageContext.request.contextPath}/welcome">Main Page</a>
<div>
    Current Time :<%= new java.util.Date() %><br>
</div>
</body>


</html>
