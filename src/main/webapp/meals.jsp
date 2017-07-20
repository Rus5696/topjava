<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 18.07.2017
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th width="120">id</th>
        <th width="120">dateTime</th>
        <th width="120">description</th>
        <th width="120">calories</th>


    </tr>
    <c:forEach items="${mealsList}" var="meal">
        <tr style="color: <c:out value="${meal.isExceed() == true ? 'crimson' : 'darkgreen'}" />">
            <td>${meal.id}</td>
            <td>${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?action=edit&mealId=<c:out value="${meal.id}"/>">Update</a></td>
            <td><a href="meals?action=delete&mealId=<c:out value="${meal.id}"/>">Delete</a></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
