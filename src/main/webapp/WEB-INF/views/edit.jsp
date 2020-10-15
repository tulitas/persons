<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hi</title>
</head>
<body>
<div>
    <section>
        <form action="" th:action="@{/options/edit(id=${Persons})}" method="post">
            <div>
                <input type="text" name="login" id="login" value="${personToEdit.get().login}">
                <input hidden type="text" name="password" id="password" value="${personToEdit.get().password}">
                <input type="text" name="fullName" id="full_name" value="${personToEdit.get().fullName}"/>
                <input type="text" id="dateofbirth" name="dateofbirth" value="${personToEdit.get().dateOfBirth}">
                <br/>
                <button class="add_button"> Pievienot</button>
            </div>

        </form>
    </section>
</div>
<a href="${pageContext.request.contextPath}/">Main Page</a>

</body>
</html>
