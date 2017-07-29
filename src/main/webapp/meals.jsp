<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>Meal list</title>
    <style>
        .normal {
            color: green;
        }

        .exceeded {
            color: red;
        }
    </style>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <form method="post" action="meals" >
        <table cellpadding="8" cellspacing="0">
            <tr>
                <td>Дата от</td>
                <td><input type="date" name="startDate"></td>
                <td>Время от</td>
                <td><input type="time" name="startTime"></td>
            </tr>
            <tr>
                <td>Дата до</td>
                <td><input type="date" name="endDate"></td>
                <td>Время до</td>
                <td><input type="time" name="endTime"></td>
            </tr>
        </table>
        <button type="submit" name="filter">Apply</button>
        <button type="submit" name="resetFilter">Reset</button>
    </form>
    <h2>Meal list</h2>
    <a href="meals?action=create">Add Meal</a>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>
                        <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                        <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                        ${fn:formatDateTime(meal.dateTime)}
                </td>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
                <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>