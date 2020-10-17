<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/created.css"/>" rel="stylesheet">


    <title>hi</title>
</head>
<body>

<div class="b-container">
    Nice!!!
</div>

<div class="b-popup">
    Registration Success
    <div class="b-popup-content">

        <table style="word-wrap: break-word" border="7">
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Age</th>
                <th>Date Of Birth</th>
            </tr>
            <tr>
                <td width="75">${personToPopUp.id}</td>

                <td width="50">${personToPopUp.fullName}</td>
                <td width="50">${personToPopUp.age}</td>
                <td width="50">${personToPopUp.dateOfBirth}</td>

            </tr>
        </table>
        <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="location.href='/login'">Close</button>
    </div>
</div>
<a href="${pageContext.request.contextPath}/">Main Page</a>
</body>
</html>
