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
    <link rel="stylesheet" href="webjars/datatables/1.10.15/media/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.0/lib/noty.css"/>
    <link rel="shortcut icon" href="resources/images/icon-meal.png">
    <link rel="stylesheet" type="text/css" href="webjars/datetimepicker/2.5.4/jquery.datetimepicker.css" >

    <!--http://stackoverflow.com/a/24070373/548473-->
    <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js" defer></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.15/media/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.15/media/js/dataTables.bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/noty/3.1.0/lib/noty.min.js" defer></script>
    <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.js" defer></script>
    <script type="text/javascript" src="webjars/datetimepicker/2.5.4/build/jquery.datetimepicker.full.min.js"></script>

</head>

</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
