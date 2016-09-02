<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.css"/>"
          rel="stylesheet">
    <link href="<c:url value="${pageContext.request.contextPath}/webjars/font-awesome/4.6.3/css/font-awesome.css"/>"
          rel="stylesheet">
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/2.1.4/jquery.js"/>"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.js"/>"></script>
    <title>Главная</title>
<body>
<div class="container" style="margin-top: 50px;">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2 class="page-header">
                Проект "Gelius",
                <small>доступные страницы</small>
            </h2>
        </div>
        <div class="panel-body">


            <div class="list-group text-center">
                <a href="/products/register" class="list-group-item">Реестр продукции</a>
                <a href="/products/newProduct" class="list-group-item">Новый продукт</a>
                <a href="#" class="list-group-item disabled">Страница еще не доступна</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
