<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
    <link href="/resources/css/font-awesome/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" type='text/css'>
    <link href="/resources/css/jquery.dynatable.css" rel="stylesheet type='text/css'">

    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/jquery.min.js"></script>

    <script src="/resources/js/list.js"></script>
    <script src="/resources/js/jquery.dynatable.js"></script>
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
                                <a class="btn btn-default btn-success text-left"><em class="fa fa-plus"></em></a>
                            </div>

                            <div class="col col-xs-1 text-left">
                                <a class="btn btn-default btn-success text-left"><em class="fa fa-pencil"></em></a>
                            </div>

                            <div class="col col-xs-1">
                                <a class="btn btn-default btn-success text-left"><em class="fa fa-check"></em></a>
                            </div>

                            <div class="col col-xs-1">
                                <a class="btn btn-default btn-success text-left"><em class="fa fa-copy"></em></a>
                            </div>

                        </div>

                        <div align = "centr">
                            <h3 class="panel-title">Реестр продукции</h3>
                        </div>

                    </div>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-list table-hover" id="mytable">
                            <thead>
                            <tr>
                                <!--                        <th><em class="fa fa-cog"></em></th>-->
                                <th class="hidden-xs">№</th>
                                <th>Клиент</th>
                                <th>Наименование продукции</th>
                                <th>Тип изделия</th>
                                <th>Длина внутренняя</th>
                                <th>Ширина внутрення</th>
                                <th>Высота внутренняя</th>
                                <th>Марка</th>
                                <th>Профиль</th>
                                <th>Цвет</th>
                                <th>Печать</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="success">
                                <!--
                                                            <td align="center">
                                                              <a class="btn btn-default"><em class="fa fa-pencil"></em></a>
                                                              <a class="btn btn-danger"><em class="fa fa-trash"></em></a>
                                                            </td>
                                -->
                                <td class="hidden-xs">0001</td>
                                <td>АВК</td>
                                <td> </td>
                                <td>Ящик(4 клапана)</td>
                                <td>385</td>
                                <td>300</td>
                                <td>180</td>
                                <td>Т-21</td>
                                <td>В</td>
                                <td>бур/бур</td>
                                <td>АВК14</td>
                            </tr>

                            <tr>
                                <td class="hidden-xs">0002</td>
                                <td>Петрущенко</td>
                                <td> </td>
                                <td>Лоток</td>
                                <td>400</td>
                                <td>300</td>
                                <td>145</td>
                                <td>П-31</td>
                                <td>ВЕ</td>
                                <td>бел/бур</td>
                                <td>Яблоки</td>
                            </tr>

                            <tr class="success">
                                <td class="hidden-xs">0003</td>
                                <td>Ласунка</td>
                                <td> </td>
                                <td>Ящик (4 клапана)</td>
                                <td>410</td>
                                <td>300</td>
                                <td>180</td>
                                <td>Т-21</td>
                                <td>В</td>
                                <td>бур/бур</td>
                                <td>Ласунка</td>
                            </tr>

                            <tr>
                                <td class="hidden-xs">0004</td>
                                <td>Ласунка</td>
                                <td> </td>
                                <td>Ящик (4 клапана)</td>
                                <td>350</td>
                                <td>252</td>
                                <td>180</td>
                                <td>Т-21</td>
                                <td>В</td>
                                <td>бур/бур</td>
                                <td>Ласунка</td>
                            </tr>

                            <tr class="success">
                                <td class="hidden-xs">0005</td>
                                <td>Ласунка</td>
                                <td> </td>
                                <td>Ящик (4 клапана)</td>
                                <td>385</td>
                                <td>300</td>
                                <td>180</td>
                                <td>Т-21</td>
                                <td>В</td>
                                <td>бур/бур</td>
                                <td>Ласунка</td>
                            </tr>
                            </tbody>
                            <script type="text/javascript">
                                $('#mytable').dynatable();
                            </script>
                        </table>
                    </div>

                </div>
</body>
<!--
<div class="panel-footer">
<div class="row">
<div class="col col-xs-4">Page 1 of 5
</div>
<div class="col col-xs-8">
<ul class="pagination hidden-xs pull-right">
<li><a href="#">1</a></li>
<li><a href="#">2</a></li>
<li><a href="#">3</a></li>
<li><a href="#">4</a></li>
<li><a href="#">5</a></li>
</ul>
<ul class="pagination visible-xs pull-right">
<li><a href="#">«</a></li>
<li><a href="#">»</a></li>
</ul>
</div>
</div>
</div>
</div>
-->

</div></div></div>