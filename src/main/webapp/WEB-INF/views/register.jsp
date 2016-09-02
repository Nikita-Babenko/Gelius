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

    <link href="/resources/css/register.css" rel="stylesheet">
    <link href="/resources/css/general_styles.css" rel="stylesheet">

    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/2.1.4/jquery.js"/>"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.js"/>"></script>

    <title>Реестр продукции</title>


</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 ">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-md-5 col-xs-6  header_buttons icon_buttons_group">
                            <a href="/products/newProduct"
                               class="fa fa-plus fa-2x"
                               title="Добавить новый продукт"
                               aria-hidden="true">
                            </a>
                            <a href="#" class="fa fa-pencil fa-2x"
                               title="Отредактировать продукт"
                               aria-hidden="true">
                            </a>
                            <a href="#"
                               class="fa fa-check fa-2x"
                               aria-hidden="true">
                            </a>
                            <a href="#"
                               class="fa fa-copy fa-2x"
                               aria-hidden="true">
                            </a>

                        </div>

                        <div class="col-md-7 col-xs-6 header_title">
                            <p class="panel-title">Реестр продукции</p>
                        </div>

                    </div>
                </div>
                <div class="panel-body">
                    <div class="table-responsive products-panel" id="products-table">

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="/resources/js/productRegister.js" type="text/javascript"></script>

</body>
</html>

