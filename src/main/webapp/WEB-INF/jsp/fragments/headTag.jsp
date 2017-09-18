<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<fmt:setBundle basename="messages.app"/>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<title><fmt:message key="app.title"/></title>--%>
    <title><spring:message code="app.title"/></title>
    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="shortcut icon" href="resources/images/icon-meal.png">
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
