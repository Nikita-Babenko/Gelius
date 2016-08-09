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

    <!--HEADER -->
    <div class="row">
        <div class="row header">

            <div class="col-lg-9 col-md-8 col-sm-7 col-xs-7 header_left">

                <div class="col-md-12 header_top">

                    <div class="col-md-5 header_buttons">

                        <button type="button" class="btn btn-success glyphicon glyphicon-chevron-left">
                            <a href="#">
                            </a>
                        </button>

                        <button type="button" class="btn btn-success glyphicon glyphicon-pencil">
                            <a href="#">
                            </a>
                        </button>

                        <button type="button" class="btn btn-success glyphicon glyphicon-trash">
                            <a href="#">
                            </a>
                        </button>

                        <button type="button" class="btn btn-success glyphicon glyphicon-file">
                            <a href="#">
                            </a>
                        </button>

                        <button type="button" class="btn btn-success glyphicon glyphicon glyphicon-user">
                            <a href="#">
                            </a>
                        </button>

                    </div>

                    <div class="col-md-7 header_title">
                        <div class="header_title_text">
                            <p>
                                Новая техкарта №
                            </p>
                        </div>
                        <div class="header_title_input">
                            <input type="text" class="form-control" contenteditable="false">
                        </div>
                    </div>
                </div>

                <div class="col-md-12 header_down">

                    <div class="form-inline header_info">
                        <div class="form-group col-xs-12 col-sm-12 col-md-4 col-lg-4">
                            <label for="Customer">Заказчик</label>
                            <select class="form-control header_info_customer" id="Customer">
                                <option></option>
                                <option>Customer1</option>
                                <option>Customer2</option>
                                <option>Customer3</option>
                            </select>
                        </div>

                        <div class="form-group col-xs-12 col-sm-12 col-md-4 col-lg-4">
                            <label for="Name">Название</label>
                            <input type="text" class="form-control header_info_name" id="Name">
                        </div>

                        <div class="form-group col-xs-12 col-sm-12 col-md-5 col-lg-4">
                            <label for="Type">Тип изделия</label>
                            <select class="form-control header_info_type" id="Type">
                                <option></option>
                                <option>Type1</option>
                                <option>Type2</option>
                                <option>Type3</option>
                            </select>
                        </div>

                    </div>

                </div>
            </div>


            <div class="col-lg-3 col-md-4 col-sm-4 col-xs-5 header_right">
                <div class="form-group form-inline create">
                    <p>Создано</p>
                    <input type="date" class="form-control">
                </div>

                <div class="form-group form-inline update">
                    <p>Изменено</p>
                    <input type="date" class="form-control">
                </div>

                <div class="form-group form-inline do">
                    <p>Подготовил</p>
                    <input type="text" class="form-control">
                </div>

                <div class="form-group form-inline use">
                    <input type="checkbox" class="header_righ_checkbox" checked>
                    <p>Тех.карта используется</p>
                </div>
            </div>
        </div>
    </div>

    <!--BODY-->

    <div class="row">

        <!--LEFT COL-->
        <div class="col-md-5">

            <table border="1" class="table left_table">

                <tbody>

                <tr style="border: 1px solid black">
                    <td class="left_title green_color" rowspan="5">
                        <p class="vertical_left_title">Продукция</p>
                    </td>
                    <td class="products_large_td">Размеры внутренние</td>
                    <td class="products_small_td" ><input type="text"></td>
                    <td class="products_large_td" ><input type="text"></td>
                    <td class="products_small_td" ><input type="text"></td>
                </tr>

                <tr>
                    <td class="products_large_td">S теор.</td>
                    <td class="products_small_td" ><input  type="text"></td>
                    <td class="products_large_td">S факт.</td>
                    <td class="products_small_td" ><input type="text"></td>
                </tr>

                <tr>
                    <td class="products_large_td">Расчетный формат</td>
                    <td class="products_small_td">
                        <select>
                            <option></option>
                            <option>Text1</option>
                            <option>Text2</option>
                            <option>Text3</option>
                        </select>
                    </td>
                    <td class="products_large_td">Профиль</td>
                    <td class="products_small_td">
                        <select>
                            <option></option>
                            <option>Text1</option>
                            <option>Text2</option>
                            <option>Text3</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="products_large_td">Марка картона</td>
                    <td class="products_small_td">
                        <select>
                            <option></option>
                            <option>Text1</option>
                            <option>Text2</option>
                            <option>Text3</option>
                        </select>
                    </td>
                    <td class="products_large_td">Целлюлозный слой</td>
                    <td class="products_small_td">
                        <select>
                            <option></option>
                            <option>Text1</option>
                            <option>Text2</option>
                            <option>Text3</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="products_large_td">Лицевой слой</td>
                    <td class="products_small_td">
                        <select>
                            <option></option>
                            <option>Text1</option>
                            <option>Text2</option>
                            <option>Text3</option>
                        </select>
                    </td>
                    <td class="products_large_td">Внутренний слой</td>
                    <td class="products_small_td">
                        <select>
                            <option></option>
                            <option>Text1</option>
                            <option>Text2</option>
                            <option>Text3</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="left_title green_color" rowspan="4">
                        <p class="vertical_left_title">Материал</p>
                    </td>
                    <td colspan="4" class="material">
                        <textarea>

                        </textarea>
                    </td>
                </tr>

                <tr></tr>
                <tr></tr>
                <tr></tr>

                <tr>
                    <td colspan="5" class="special_conditions green_color">
                        <p>Особые условия</p>
                    </td>
                </tr>

                <tr>
                    <td colspan="5" class="special_conditions_textarea">
                        <textarea>

                        </textarea>
                    </td>
                </tr>

                <tr>
                    <td colspan="5" class="workability green_color">
                        <p>Технологичность</p>
                    </td>
                </tr>

                <tr>
                    <td colspan="5" class="workability_textarea">
                        <textarea>

                        </textarea>
                    </td>
                </tr>

                </tbody>

            </table>

        </div>

        <!--CENTER COL-->
        <div class="col-md-3">
            CENTER
        </div>


        <!--RIGHT COL-->
        <div class="col-md-4">

            <table border="1" class="table right_table">
                <tbody>

                <tr>
                    <td class="avto_left_title green_color" rowspan="8">
                        <p class="vertical_left_title">Авто</p>
                    </td>
                    <td class="avto_large_td">Способ упаковки</td>
                    <td class="avto_small_td">
                        <select>
                            <option value=""></option>
                            <option value="">Без упаковки</option>
                            <option value="">Паллета, лента, стрейч</option>
                            <option value="">Паллета, лента, без стрейча</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="avto_large_td">В пачке, шт.</td>
                    <td class="avto_small_td"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td class="avto_large_td">В транспортном пакете, шт.</td>
                    <td class="avto_small_td"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td class="avto_large_td">
                        Размеры пакета
                        <input class="embeded_input" type="text" value=""/>
                    </td>
                    <td class="avto_small_td">
                        <div class="inputs">
                            <input type="text" value=""/>
                            <input type="text" value=""/>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td class="avto_large_td">Поддон</td>
                    <td class="avto_small_td">
                        <select>
                            <option value=""></option>
                            <option value="">1200x800</option>
                            <option value="">1200x1000</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="avto_large_td">Размещение на поддоне</td>
                    <td class="avto_small_td">
                        <select>
                            <option value=""></option>
                            <option value="">1 пачка в ряду</option>
                            <option value="">2 пачки в ряду</option>
                            <option value="">3 пачки в ряду</option>
                        </select>
                    </td>
                </tr>


                <tr>
                    <td class="avto_large_td">Рядов на поддоне</td>
                    <td class="avto_small_td"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td class="avto_large_td">Загрузка автомобиля, шт.</td>
                    <td class="avto_small_td"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td colspan="3" class="attachments" style="position: relative">
                        <div class="links">
                            <a href="#">тех.карта.pdf</a><br/>
                            <a href="#">ссылка2.ai</a>
                        </div>
                        <div class="buttons">
                            <a class="fa fa-paperclip fa-2x" href="#">
                            </a>
                            <a class="fa fa-trash-o fa-2x" href="#">
                            </a>
                        </div>

                    </td>
                </tr>

                <tr>
                    <td colspan="3" class="right_table_title green_color">
                        Биговки
                    </td>
                </tr>

                <tr>
                    <td colspan="3" class="all">
                    </td>
                </tr>

                <tr>
                    <td class="avto_large_td" colspan="2">Производственный формат</td>
                    <td class="avto_small_td"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td colspan="3" class="right_table_title green_color">
                        Просечки
                    </td>
                </tr>

                <tr>
                    <td colspan="3" class="all">
                    </td>
                </tr>

                </tbody>
            </table>

            <div class="buttonContainer">
                <div class="buttons">
                    <a class="fa fa-pencil  fa-3x" href="#">
                    </a>
                    <a class="fa fa-paperclip fa-3x" href="#">
                    </a>
                    <a class="fa fa-trash fa-3x" href="#">
                    </a>
                </div>
            </div>

        </div>

    </div>
</div>



<script src="/resources/js/jsx/newProduct.js" type="text/javascript"></script>

</body>
</html>