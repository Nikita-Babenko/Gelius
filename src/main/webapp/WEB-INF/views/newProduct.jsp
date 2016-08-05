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
        <div class="col-md-4" id="rightColumn">


            <div class="cellVerticalHeader">Aвто</div>

            <div class="cellLabel">Способ упаковки</div>
            <div class="cellValue">
                <select id="">
                    <option value="1">Без упаковки</option>
                    <option value="2">Паллета, лента, стрейч</option>
                    <option value="3">Паллета, лента, без стрейча</option>
                </select>
            </div>

            <div class="cellLabel">В пачке, шт.</div>
            <div class="cellValue">
                <input type="text" id="" value="" />
            </div>

            <div class="cellLabel">В транспортном пакете, шт.</div>
            <div class="cellValue">
                <input type="text" id="" value="" />
            </div>

            <div class="cellLabel packingDims">Размеры пакета</div>
            <div class="cellValue">
                <input type="text" id="" value="" placeholder=" длина" />
            </div>
            <div class="cellValue">
                <input type="text" id="" value="" placeholder=" ширина" />
            </div>
            <div class="cellValue">
                <input type="text" id="" value="" placeholder=" высота" />
            </div>

            <div class="cellLabel">Поддон</div>
            <div class="cellValue">
                <select id="">
                    <option value="1">1200x800</option>
                    <option value="2">1200x1000</option>
                </select>
            </div>

            <div class="cellLabel">Размещение на поддоне</div>
            <div class="cellValue">
                <select id="">
                    <option value="1">1 пачка в ряду</option>
                    <option value="2">2 пачки в ряду</option>
                    <option value="3">3 пачки в ряду</option>
                </select>
            </div>

            <div class="cellLabel">Рядов на поддоне</div>
            <div class="cellValue">
                <input type="text" id="" value="" />
            </div>

            <div class="cellLabel noBottomBorder">Загрузка автомобиля, шт.</div>
            <div class="cellValue noBottomBorder">
                <input type="text" id="" value="" />
            </div>

            <div class="attachments">

                <div class="btnSmall">
                    <em class="fa fa-paperclip fa-2x" aria-hidden="true"></em>
                </div>
                <div class="btnSmall">
                    <em class="fa fa-trash fa-2x" aria-hidden="true"></em>
                </div>

                <div>
                    <span style="">тех.карта.pdf</span><br/>
                    <span style="">ссылка2.ai</span><br/>
                    <span style="">ссылка3.png</span><br/>
                </div>

            </div>

            <div class="cellHeader">Биговки</div>
            <div class="bigovkiContainer">
                <div class="cellValue">
                    <input type="text" id="" value="" />
                </div>
                <div class="cellLabel">+</div>
                <div class="cellValue">
                    <input type="text" id="" value="" />
                </div>
                <div class="cellLabel">+</div>
                <div class="cellValue">
                    <input type="text" id="" value="" />
                </div>
                <div class="cellValue">
                    <input type="text" id="" value="" />
                </div>
            </div>

            <div class="cellLabel mFormat">Производственный формат</div>
            <div class="cellValue">
                <input type="text" id="" value="" />
            </div>

            <div class="cellHeader">Просечки</div>
            <div class="prosechkiContainer">
                <div class="cellValue leftBorder">
                    <input type="text" id="" value="" />
                </div>
                <div class="cellValue">
                    <input type="text" id="" value="" />
                </div>
                <div class="cellValue">
                    <input type="text" id="" value="" />
                </div>
                <div class="cellValue">
                    <input type="text" id="" value="" />
                </div>
                <div class="cellValue">
                    <input type="text" id="" value="" />
                </div>
            </div>

            <div class="buttons">
                &nbsp;
                <div class="btn">
                    <em class="fa fa-question fa-3x" aria-hidden="true"></em>
                </div>
                <div class="btn">
                    <em class="fa fa-paperclip fa-3x" aria-hidden="true"></em>
                </div>
                <div class="btn">
                    <em class="fa fa-trash fa-3x" aria-hidden="true"></em>
                </div>
            </div>


        </div>

    </div>
</div>



<script src="/resources/js/jsx/newProduct.js" type="text/javascript"></script>

</body>
</html>
