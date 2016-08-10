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

    <link href="/resources/css/newProduct.css" rel="stylesheet">

    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/2.1.4/jquery.js"/>"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.js"/>"></script>

    <title>Новая техкарта</title>

</head>
<body>


    <div class="container-fluid target">

        <div class="row" id="headerProduct">

        </div>

        <div class="row" id = "bodyProduct">

        </div>

    </div>


    <script src="<c:url value="${pageContext.request.contextPath}/webjars/react/15.2.1/react-with-addons.min.js"/>"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/react/15.2.1/react-dom.min.js"/>"></script>
    <script src="/resources/js/react/babel.min.js"></script>
    <script src="/resources/js/jsx/newProduct.js" type="text/babel"></script>

</body>
</html>