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

    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/2.1.4/jquery.js"/>"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.js"/>"></script>

    <title>Реестр продукции</title>


</head>

<body>
<div class="container" style="margin-top: 50px;">
    <div class="row">
        <div class="col-md-12 ">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="col col-xs-1 ">
                                <a class="btn btn-success text-left" href="/products/newProduct"><em
                                        class="fa fa-plus"></em></a>
                            </div>
                            <div class="col col-xs-1 text-left">
                                <a class="btn btn-success text-left"><em class="fa fa-pencil"></em></a>
                            </div>
                            <div class="col col-xs-1">
                                <a class="btn btn-success text-left"><em class="fa fa-check"></em></a>
                            </div>
                            <div class="col col-xs-1">
                                <a class="btn btn-success text-left"><em class="fa fa-copy"></em></a>
                            </div>
                        </div>

                        <div align="centr">
                            <h3 class="panel-title">Реестр продукции</h3>
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

