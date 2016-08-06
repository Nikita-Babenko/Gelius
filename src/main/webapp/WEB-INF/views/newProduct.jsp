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
        HEADER
    </div>

    <!--BODY-->
    <div class="row">

        <!--LEFT COL-->
        <div class="col-md-5">

            <table border="1" class="table table-bordered left_table">

                <tbody>

                <tr>
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

            <table border="1" class="table table-bordered rightTable">
                <tbody>

                <tr>
                    <td rowspan="8" colspan="2" class="title leftTitle green_color">
                        <p class="verticalLeftTitle">Авто</p>
                    </td>
                    <td colspan="12" class="label">Способ упаковки</td>
                    <td colspan="6" class="value">
                        <select>
                            <option value="">Без упаковки</option>
                            <option value="">Паллета, лента, стрейч</option>
                            <option value="">Паллета, лента, без стрейча</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td  colspan="12" class="label">В пачке, шт.</td>
                    <td colspan="6" class="value"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td  colspan="12" class="label">В транспортном пакете, шт.</td>
                    <td colspan="6" class="value"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td colspan="9" class="label dimensions">Размеры пакета</td>
                    <td class="value dimensionLength" colspan="3"><input type="text" value="" placeholder="длина" /></td>
                    <td class="value dimensionWidth" colspan="3"><input type="text" value="" placeholder="ширина" /></td>
                    <td class="value dimensionHeight" colspan="3"><input type="text" value="" placeholder="высота" /></td>
                </tr>

                <tr>
                    <td  colspan="12" class="label">Поддон</td>
                    <td colspan="6" class="value">
                        <select>
                            <option value="">1200x800</option>
                            <option value="">1200x1000</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td  colspan="12" class="label">Размещение на поддоне</td>
                    <td colspan="6" class="value">
                        <select>
                            <option value="">1 пачка в ряду</option>
                            <option value="">2 пачки в ряду</option>
                            <option value="">3 пачки в ряду</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td  colspan="12" class="label">Рядов на поддоне</td>
                    <td colspan="6" class="value"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td  colspan="12" class="label">Загрузка автомобиля, шт.</td>
                    <td colspan="6" class="value"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td colspan="15" class="attachments">
                        <a>тех.карта.pdf</a><br/>
                        <a>ссылка2.ai</a>
                    </td>
                    <td colspan="5" class="attachmentsButtons">
                        <div class="buttonSmall">
                            <em class="fa fa-trash fa-2x" aria-hidden="true"></em>
                        </div>
                        <div class="buttonSmall">
                            <em class="fa fa-paperclip fa-2x" aria-hidden="true"></em>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td colspan="20" class="title green_color">
                        Биговки
                    </td>
                </tr>

                <tr class="bigovkiRow">
                    <td class="value" colspan="4"><input type="text" value="" /></td>
                    <td class="label" colspan="2">+</td>
                    <td class="value" colspan="4"><input type="text" value="" /></td>
                    <td class="label" colspan="2">+</td>
                    <td class="value" colspan="4"><input type="text" value="" /></td>
                    <td class="value" colspan="4"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td colspan="12" class="label">Производственный формат</td>
                    <td colspan="8" class="value"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td colspan="20" class="title green_color">
                        Просечки
                    </td>
                </tr>

                <tr class="prosechkiRow">
                    <td colspan="4" class="value"><input type="text" value="" /></td>
                    <td colspan="4" class="value"><input type="text" value="" /></td>
                    <td colspan="4" class="value"><input type="text" value="" /></td>
                    <td colspan="4" class="value"><input type="text" value="" /></td>
                    <td colspan="4" class="value"><input type="text" value="" /></td>
                </tr>

                <tr>
                    <td colspan="20" class="buttonContainer">
                        <div class="buttonBig">
                            <em class="fa fa-trash fa-3x" aria-hidden="true"></em>
                        </div>
                        <div class="buttonBig">
                            <em class="fa fa-paperclip fa-3x" aria-hidden="true"></em>
                        </div>
                        <div class="buttonBig">
                            <em class="fa fa-question fa-3x" aria-hidden="true"></em>
                        </div>
                    </td>
                </tr>

                </tbody>
            </table>

        </div>

    </div>
</div>



<script src="/resources/js/jsx/newProduct.js" type="text/javascript"></script>

</body>
</html>
