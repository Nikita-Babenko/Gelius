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

    <link href="/resources/css/newProductExample.css" rel="stylesheet">

    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/2.1.4/jquery.js"/>"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.js"/>"></script>


    <title>Новая техкарта</title>

</head>
<body>

<div class="container-fluid target">
    <div class="row">
        <div class="col-md-9">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="btn-group btn-group-xs">
                                <button class="btn btn-default" type="button"><em class="fa fa-arrow-left"></em>
                                </button>
                                <button class="btn btn-default" type="button"><em class="fa fa-check-square"></em>
                                </button>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-6">
                                    <h3 class="text-left" contenteditable="false" style="">
                                        Новая тех. карта №
                                    </h3>

                                </div>
                                <div class="col-md-6">
                                    <input type="text" placeholder="text input" class="form-control"
                                           contenteditable="false">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-inline">
                        <div class="form-group">
                            <label for="exampleInput1" class="">Заказчик</label>
                            <select class="form-control" id="exampleInput1"></select>
                        </div>
                        <div class="form-group">
                            <label for="exampleInput2" class="">Название</label>
                            <input type="text" class="form-control" id="exampleInput2">
                        </div>
                        <div class="form-group">
                            <label for="exampleInput3" class="">Тип</label>
                            <select class="form-control" id="exampleInput3"></select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-group form-inline">
                <label for="exampleInput4" class="">Создано</label>

                <div class="input-group date" id="datetimepicker1">
                    <input type="text" class="form-control" id="exampleInput4">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
            <div class="form-group form-inline">
                <label for="exampleInput5" class="">Изменено</label>
                <input type="text" class="form-control" id="exampleInput5">
            </div>
            <div class="form-group form-inline">
                <label for="exampleInput5" class="">Подготовил</label>
                <input type="text" class="form-control" id="exampleInput5">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-5">
            <table class="table table-bordered products">
                <tbody>
                <tr>
                    <td class="darkgreen" rowspan="5">
                        <p class="vertical-text">Продукция</p>
                    </td>
                    <td class="">Размеры внутренние</td>
                    <td class="" contenteditable="false"><input type="text" placeholder="Длина" class="form-control">
                    </td>
                    <td class=""><input type="text" placeholder="Ширина" class="form-control"></td>
                    <td class=""><input type="text" placeholder="Высота" class="form-control"></td>
                </tr>
                <tr>
                    <td class="">S теор.</td>
                    <td class=""></td>
                    <td class="">S факт.</td>
                    <td class=""></td>
                </tr>
                <tr>
                    <td class="">Расчетный формат</td>
                    <td class=""></td>
                    <td class="">Профиль</td>
                    <td class=""></td>
                </tr>
                <tr>
                    <td class="">Марка картона</td>
                    <td class=""></td>
                    <td class="">Целлюлозный слой</td>
                    <td class=""></td>
                </tr>
                <tr>
                    <td class="">Лицевой слой</td>
                    <td class=""></td>
                    <td class="">Внутренний слой</td>
                    <td class=""></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-md-3">
            <table class="table table-bordered products">
                <tbody>
                <tr>
                    <td class="darkgreen" rowspan="6">
                        <p class="vertical-text">Продукция</p>
                    </td>
                    <td class="">Размеры заготовки</td>
                    <td class=""><input type="text" placeholder="Длина" class="form-control"></td>
                    <td class=""><input type="text" placeholder="Ширина" class="form-control"></td>
                </tr>
                <tr>
                    <td class="">Количество с листа</td>
                    <td colspan="2" class=""></td>
                </tr>
                <tr>
                    <td class="">Формат заготовки</td>
                    <td colspan="2" class=""></td>
                </tr>
                <tr>
                    <td class="">Соединение клапана</td>
                    <td colspan="2" class=""></td>
                </tr>
                <tr>
                    <td class="">Штамп</td>
                    <td colspan="2" class=""></td>
                </tr>
                <tr>
                    <td class="">Клише</td>
                    <td colspan="2" class=""></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-md-4">
            <table class="table table-bordered products">
                <tbody>
                <tr>
                    <td class=" darkgreen" rowspan="8">
                        <p class="vertical-text">Авто</p>
                    </td>
                    <td class="">Способ упаковки</td>
                    <td class=""><input type="text" placeholder="text input" class="form-control"></td>
                </tr>
                <tr>
                    <td class="">В пачке, шт.</td>
                    <td class=""></td>
                </tr>
                <tr>
                    <td class="">В транспортном пакете, шт.</td>
                    <td class=""></td>
                </tr>
                <tr>
                    <td class="">Размеры пакета</td>
                    <td class=""></td>
                </tr>
                <tr>
                    <td class="">Поддон</td>
                    <td class=""></td>
                </tr>
                <tr>
                    <td class="">Размещение на поддоне</td>
                    <td class=""></td>
                </tr>
                <tr>
                    <td class="">Рядов на поддоне</td>
                    <td class=""></td>
                </tr>
                <tr>
                    <td class="">Загрузка автомобиля</td>
                    <td class=""></td>
                </tr>
                </tbody>
            </table>
        </div>

    </div>
</div>

<script src="/resources/js/jsx/newProductExample.js" type="text/javascript"></script>

</body>
</html>
