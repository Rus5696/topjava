<%--
  Created by IntelliJ IDEA.
  User: Олег
  Date: 20.07.2017
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="POST" action='meals?action=meals'>
        ID : <input type="text" readonly="readonly" name="id"
                         value="<c:out value="${meal.id}" />"/> <br/>
        dateTime : <input
            type="text" name="dateTime"
            value="<c:out value="${meal.dateTime}" />" />"/> <br/>
        description : <input
            type="text" name="description"
            value="<c:out value="${meal.description}" />"/> <br/>
        calories : <input
            type="text" name="calories"
            value="${meal.calories}" />"/> <br/>
        exceed : <input
            type="checkbox" name="exceed"
        ${meal.exceed ? 'checked' : ''} />"/> <br/>
         <input type="submit" value="Submit"/>
    </form>
</body>
</html>
