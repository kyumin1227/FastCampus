<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>List</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>#</th>
        <th>userId</th>
        <th>name</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr>
            <th scope="row">${status.count}</th>
            <td>${user.userId}</td>
            <td>${user.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>