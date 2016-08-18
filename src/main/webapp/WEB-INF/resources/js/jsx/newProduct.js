var product = {};
product["productNumber"] = '';
product["isNew"] = '';
product["productCreateDateValue"] = '';
product["productUpdateDateValue"] = '';
product["personPrepared"] = '';
product["isUse"] = '';
product["client"] = '';
product["productName"] = '';
product["productType"] = '';
product["innerLength"] = '';
product["innerWidth"] = '';
product["innerHeight"] = '';
product["theoreticalSquare"] = '';
product["actualSquare"] = '';
product["format"] = '';
product["profile"] = '';
product["cardboardBrand"] = '';
product["celluloseLayer"] = '';
product["innerLayer"] = '';
product["faceLayer"] = '';
product["material"] = '';
product["sizeWorkpieceLength"] = '';
product["sizeWorkpieceWidth"] = '';
product["numberFromSheet"] = '';
product["blankFormat"] = '';
product["connectionValve"] = '';
product["stamp"] = '';
product["cliche"] = '';
product["packing"] = '';
product["numberInPack"] = '';
product["numberInTransportPackage"] = '';
product["packageLength"] = '';
product["packageWidth"] = '';
product["packageHeight"] = '';
product["pallet"] = '';
product["palletPlacement"] = '';
product["numberLoadCar"] = '';
product["palletRows"] = '';
product["productionFormat"] = '';


// logging
var debug = (sessionStorage["debug"] == "true") ? true : false;

function log(text) {
    if (debug == true) {
        console.log(text);
    }
}

//
var newProductContainer = React.createClass({
    render: function () {
        return (
            <div className="container-fluid target">

            </div>
        );
    }
});

newProductContainer.newProductHeaderLeft = React.createClass({
    render: function () {
        return (
            <div className="col-lg-9 col-md-8 col-sm-7 col-xs-7 header_left">

                <div className="col-md-12 header_top">

                    <div className="col-md-5 col-xs-10 col-sm-11  header_buttons">

                        <button type="button" className="btn btn-success glyphicon glyphicon-chevron-left">
                            <a href="#">
                            </a>
                        </button>

                        <button type="button" className="btn btn-success glyphicon glyphicon-pencil">
                            <a href="#">
                            </a>
                        </button>

                        <button type="button" className="btn btn-success glyphicon glyphicon-trash">
                            <a href="#">
                            </a>
                        </button>

                        <button type="button" className="btn btn-success glyphicon glyphicon-file">
                            <a href="#">
                            </a>
                        </button>

                        <button type="button" className="btn btn-success glyphicon glyphicon glyphicon-user">
                            <a href="#">
                            </a>
                        </button>

                    </div>

                    <div className="col-md-7 col-xs-10 col-sm-11 header_title">
                        <div className="header_title_text">
                            <p>
                                Новая техкарта №
                            </p>
                        </div>
                        <div className="header_title_input">
                            <input type="text" className="form-control" id="productNumber" contenteditable="false" id="productNumber"/>
                            <div className="isNew">
                                <input type="checkbox" id="isNew"/>
                                <p>Новая Карта</p>
                            </div>
                        </div>
                    </div>

                </div>

                <div className="col-md-12 header_down">

                    <div className="form-inline header_info">
                        <div className="form-group col-xs-12 col-sm-8 col-md-6 col-lg-4">
                            <label for="Customer">Заказчик</label>
                            <select className="form-control header_info_customer" id="client">

                            </select>
                        </div>

                        <div className="form-group col-xs-12 col-sm-8 col-md-6 col-lg-4">
                            <label for="Name">Название</label>
                            <input type="text" className="form-control header_info_name" id="productName" />
                        </div>


                        <div className="form-group col-xs-12 col-sm-8 col-md-6 col-lg-4">
                            <label for="Type">Тип изделия</label>
                            <select className="form-control header_info_type" id="productType">

                            </select>
                        </div>

                    </div>
                </div>
            </div>
        );
    }
});

newProductContainer.newProductHeaderRight = React.createClass({
    render: function () {
        return (
            <div className="col-lg-3 col-md-4 col-sm-5 col-xs-5 header_right">
                <div className="form-group form-inline create">
                    <p>Создано</p>
                    <input type="date" className="form-control" id="productCreateDate"/>
                </div>

                <div className="form-group form-inline update">
                    <p>Изменено</p>
                    <input type="date" className="form-control" id="productUpdateDate"/>
                </div>

                <div className="form-group form-inline do">
                    <p>Подготовил</p>
                    <input type="text" className="form-control" id="personPrepared"/>
                </div>

                <div className="form-group form-inline use">
                    <input type="checkbox" className="header_righ_checkbox" id="isUse"/>
                    <p>Тех.карта используется</p>
                </div>
            </div>
        );
    }
});

newProductContainer.newProductBodyLeft = React.createClass({
    render: function () {
        return (
            <div className="col-md-12 col-lg-5 left">
                <table border="1" className="table left_table">

                    <tbody>

                    <tr>
                        <td className="left_title green_color" rowSpan="5">
                            <p className="vertical_left_title">Продукция</p>
                        </td>
                        <td className="products_large_td">Размеры внутренние</td>
                        <td className="products_small_td" ><input type="number" id="innerLength"/></td>
                        <td className="products_large_td" ><input type="number" id="innerWidth"/></td>
                        <td className="products_small_td" ><input type="number" id="innerHeight"/></td>
                    </tr>

                    <tr>
                        <td className="products_large_td">S теор.</td>
                        <td className="products_small_td" ><input  type="number" id="theoreticalSquare"/></td>
                        <td className="products_large_td">S факт.</td>
                        <td className="products_small_td" ><input type="number" id="actualSquare"/></td>
                    </tr>

                    <tr>
                        <td className="products_large_td">Расчетный формат</td>
                        <td className="products_small_td">
                            <select id="format">

                            </select>
                        </td>
                        <td className="products_large_td">Профиль</td>
                        <td className="products_small_td">
                            <select id="profile">

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td className="products_large_td">Марка картона</td>
                        <td className="products_small_td">
                            <select id="cardboardBrand">

                            </select>
                        </td>
                        <td className="products_large_td">Целлюлозный слой</td>
                        <td className="products_small_td">
                            <select id="celluloseLayer">

                            </select>
                        </td>
                    </tr>


                    <tr>
                        <td className="products_large_td">Лицевой слой</td>
                        <td className="products_small_td">
                            <select id="faceLayer">
                            </select>
                        </td>
                        <td className="products_large_td">Внутренний слой</td>
                        <td className="products_small_td">
                            <select id="innerLayer">

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td className="left_title green_color" rowSpan="4">
                            <p className="vertical_left_title">Материал</p>
                        </td>
                        <td colSpan="4" className="material">
                        <textarea id="material">

                        </textarea>
                        </td>
                    </tr>

                    <tr></tr>
                    <tr></tr>
                    <tr></tr>

                    <tr>
                        <td colSpan="5" className="special_conditions green_color">
                            <p>Особые условия</p>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="5" className="special_conditions_textarea">
                        <textarea>

                        </textarea>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="5" className="workability green_color">
                            <p>Технологичность</p>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="5" className="workability_textarea">
                        <textarea>

                        </textarea>
                        </td>
                    </tr>

                    </tbody>

                </table>
            </div>
        );
    }
});

newProductContainer.newProductBodyMiddle = React.createClass({
    render: function () {
        return (
            <div className="col-md-12 col-lg-3 middle">

                <table border="1" className="table middle_table">

                    <tbody>

                    <tr>
                        <td className="middle_left_title green_color" rowSpan="6">
                            <p className="vertical_left_title">Продукция</p>
                        </td>

                        <td className="middle_products_large_td">Размеры заготовки</td>
                        <td className="middle_products_small_td">
                            <div className="inputs">
                                <input type="number" className="input_1" id="sizeWorkpieceLength"/>
                                <input type="number" className="input_2" id="sizeWorkpieceWidth" disabled value="0"/>
                            </div>
                        </td>

                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Количество с листа</td>
                        <td className="middle_products_small_td"><input type="number" id="numberFromSheet"/></td>
                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Формат заготовки</td>
                        <td className="middle_products_small_td"><input required type="number" id="blankFormat"/></td>
                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Соединение клапана</td>
                        <td className="middle_products_small_td">
                            <select id="connectionValve">

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Штамп</td>
                        <td className="middle_products_small_td"><input type="text" id="stamp"/></td>
                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Клише</td>
                        <td className="middle_products_small_td"><input type="text" id="cliche"/></td>
                    </tr>

                    <tr>
                        <td className="middle_left_title green_color" rowSpan="6">
                            <p className="vertical_left_title">Печать</p>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="print_td">
                            <div className="print_input_1">
                                <input type="text"  value="Название" disabled/>
                            </div>
                            <div className="print_input_2">
                                <input type="text"  value="Цена" disabled/>
                            </div>
                            <div className="print_input_3">
                                <input type="text"  value="S запечатки" disabled/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="print_td">
                            <div className="print_input_1">
                                <input type="text"/>
                            </div>
                            <div className="print_input_2">
                                <input type="text"/>
                            </div>
                            <div className="print_input_3">
                                <input type="text"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="print_td">
                            <div className="print_input_1">
                                <input type="text"/>
                            </div>
                            <div className="print_input_2">
                                <input type="text"/>
                            </div>
                            <div className="print_input_3">
                                <input type="text"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="print_td">
                            <div className="print_input_1">
                                <input type="text"/>
                            </div>
                            <div className="print_input_2">
                                <input type="text"/>
                            </div>
                            <div className="print_input_3">
                                <input type="text"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="print_td">
                            <div className="print_input_1">
                                <input type="text"/>
                            </div>
                            <div className="print_input_2">
                                <input type="text"/>
                            </div>
                            <div className="print_input_3">
                                <input type="text"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="4" className="notes green_color">
                            <p>Примечания</p>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="4" className="notes_all">
                            <div className="notes_inputs">
                                <input type="text" className="note_input_1"/>
                                <input type="text" className="note_input_2"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="4" className="notes_all">
                            <div className="notes_inputs">
                                <input type="text" className="note_input_1"/>
                                <input type="text" className="note_input_2"/>
                            </div>
                        </td>
                    </tr>


                    <tr>
                        <td colSpan="4" className="notes_all">
                            <div className="notes_inputs">
                                <input type="text" className="note_input_1"/>
                                <input type="text" className="note_input_2"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="4" className="notes_all">
                            <div className="notes_inputs">
                                <input type="text" className="note_input_1"/>
                                <input type="text" className="note_input_2"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="4" className="notes_all">
                            <div className="notes_inputs">
                                <input type="text" className="note_input_1"/>
                                <input type="text" className="note_input_2"/>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </table>

            </div>
        );
    }
});

newProductContainer.newProductBodyRight = React.createClass({
    render: function () {
        return (
            <div className="col-md-12 col-lg-4 right">

                <table border="1" className="table right_table">

                    <tbody>

                    <tr>
                        <td className="avto_left_title green_color" rowSpan="8">
                            <p className="vertical_left_title">Авто</p>
                        </td>
                        <td className="avto_large_td">Способ упаковки</td>
                        <td className="avto_small_td">
                            <select id="packing">

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">В пачке, шт.</td>
                        <td className="avto_small_td"><input type="number" id="numberInPack"/></td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">В транспортном пакете, шт.</td>
                        <td className="avto_small_td"><input type="number" id="numberInTransportPackage"/></td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">
                            Размеры пакета
                            <input className="embeded_input" type="number" id="packageLength"/>
                        </td>
                        <td className="avto_small_td">
                            <div className="inputs">
                                <input type="number" className="input_1" id="packageWidth"/>
                                <input type="number" className="input_2" id="packageHeight"/>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">Поддон</td>
                        <td className="avto_small_td">
                            <select id="pallet">

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">Размещение на поддоне</td>
                        <td className="avto_small_td">
                            <select id="palletPlacement">

                            </select>
                        </td>
                    </tr>


                    <tr>
                        <td className="avto_large_td">Рядов на поддоне</td>
                        <td className="avto_small_td"><input type="number" id="palletRows"/></td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">Загрузка автомобиля, шт.</td>
                        <td className="avto_small_td"><input type="number" id="numberLoadCar"/></td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="attachments">
                            <div className="links">
                                <a href="#">тех.карта.pdf</a><br/>
                                <a href="#">ссылка2.ai</a>
                            </div>
                            <div className="buttons">
                                <a className="fa fa-paperclip fa-2x" href="#">
                                </a>
                                <a className="fa fa-trash-o fa-2x" href="#">
                                </a>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="right_table_title green_color">
                            Биговки
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="bigovki_all">
                            <div className="bigovki_inputs_1">
                                <input type="number" className="bigovki_input_1 sumBigovki" />
                                <input type="text" className="bigovki_input_2" value="+" disabled/>
                            </div>
                            <div className="bigovki_inputs_2">
                                <input type="number" className="bigovki_input_1 sumBigovki"/>
                                <input type="text" className="bigovki_input_2" value="+" disabled/>
                            </div>
                            <div className="bigovki_inputs_3">
                                <input type="number" className="bigovki_input_3 sumBigovki" />
                                <input type="number" className="bigovki_input_4 sumBigovki" />
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td" colSpan="2">Производственный формат</td>
                        <td className="avto_small_td"><input type="number" id="productionFormat"/></td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="right_table_title green_color">
                            Просечки
                        </td>
                    </tr>

                    <tr>
                        <td colSpan="3" className="prosechki_all">
                            <div className="prosechki_inputs">
                                <input type="number" className="prosechki_input_1"/>
                                <input type="number" className="prosechki_input_2"/>
                                <input type="number" className="prosechki_input_3"/>
                                <input type="number" className="prosechki_input_4"/>
                                <input type="number" className="prosechki_input_5"/>
                            </div>
                        </td>
                    </tr>

                    </tbody>
                </table>

                <div className="buttonContainer">
                    <div className="buttons_bottom">
                        <a className="fa fa-pencil  fa-3x" href="#">
                        </a>
                        <a className="fa fa-plus fa-3x" href="#" id="addNew">
                        </a>
                        <a className="fa fa-trash fa-3x" href="#">
                        </a>
                    </div>
                </div>

            </div>
        );
    }
});

var AppHeader = React.createClass({
    render: function () {
        return (
            <div className="row" id="productHeader">
                <newProductContainer.newProductHeaderLeft />
                <newProductContainer.newProductHeaderRight />
            </div>
        );
    }
});

var AppBody = React.createClass({
    render: function () {
        return (
            <div className="row" id="productBody">
                <newProductContainer.newProductBodyLeft />
                <newProductContainer.newProductBodyMiddle/>
                <newProductContainer.newProductBodyRight />
            </div>
        );
    }
});

var App = React.createClass({
    getInitialState: function () {
        return {
            dictionaries: {}
        }
    },
    componentDidMount: function () {
        this.__getAllDictionaries();
        this.__sumBigovki();
        this.__createProductAndLoadToServer();
    },

    __getAllDictionaries: function () {
        $.ajax({
            type: 'get',
            contentType: "application/json",
            url: "/products/newProduct/initData",
            data: '',
            dataType: 'json',
            timeout: 100000,
            success: function (response) {

                log("get init : response : " + JSON.stringify(response));

                if (!response) {
                    console.log("Empty response on '/products/newProduct/initData'");
                    return;
                };

                if (!response["data"]) {
                    console.log("Empty 'data' in response on '/products/newProduct/initData'");
                    return;
                }

                if (response["data"]["dictionaries"]) {
                    this.setState({
                        dictionaries: response.data.dictionaries
                    });
                    this.__setAllDictionaries();
                } else {
                    console.log("Empty 'dictionaries' in response on '/products/newProduct/initData'");
                };

                if (response["data"]["productNumber"]) {
                    $('#productNumber').val(response.data.productNumber);
                } else {
                    console.log("Empty 'productNumber' in response on '/products/newProduct/initData'");
                }

            }.bind(this),
            error: function (e) {
                console.log("ERROR: ", e);
            }.bind(this)
        });
    },

    __setAllDictionaries: function () {
        var data = this.state.dictionaries;

        // client
        this.__fillOptions("client", data.client, "companyName");

        // type
        this.__fillOptions("productType", data.productType, "productType");

        // faceLayer
        this.__fillOptions("faceLayer", data.faceLayer, "faceLayer");

        // connectionValve
        this.__fillOptions("connectionValve", data.connectionValve, "connectionValve");

        // profile
        this.__fillOptions("profile", data.profile, "profile");

        // format
        this.__fillOptions("format", data.format, "format");

        // pallet
        this.__fillOptions("pallet", data.pallet, "pallet");

        // packing
        this.__fillOptions("packing", data.packing, "packing");

        // celluloseLayer
        this.__fillOptions("celluloseLayer", data.celluloseLayer, "celluloseLayer");

        // palletPlacement
        this.__fillOptions("palletPlacement", data.palletPlacement, "palletPlacement");

        // innerLayer
        this.__fillOptions("innerLayer", data.innerLayer, "innerLayer");

        // cardboardBrand
        this.__fillOptions("cardboardBrand", data.cardBoardBrand, "cardboardBrand");
    },

    __fillOptions: function (selectId, data, textColumn) {
        var options = $("#" + selectId);
        options.empty();
        $.each(data, function (item) {
            options.append($("<option />").val(data[item].id).text(data[item][textColumn]));
        });
    },

    __createProductAndLoadToServer : function () {
        $("#addNew").click(function() {
            if(validationRequiredFields() === false) {
                return;
            }
            product["isNew"] = $('#isNew').is(":checked");
            product["isUse"] = $('#isUse').is(":checked");
            product["productNumber"] = $('#productNumber').val();
            product["productName"] = $('#productName').val();
            product["productCreateDateValue"] = $('#productCreateDate').val();
            product["productUpdateDateValue"] = $('#productUpdateDate').val();
            product["personPrepared"] = $('#personPrepared').val();
            product["innerLength"] = $('#innerLength').val();
            product["innerWidth"] = $('#innerWidth').val();
            product["innerHeight"] = $('#innerHeight').val();
            product["profile"] = Number($('#profile :selected').val());
            product["client"] = Number($('#client :selected').val());
            product["cardboardBrand"] = Number($('#cardboardBrand :selected').val());
            product["productType"] = Number($('#productType :selected').val());
            product["celluloseLayer"] = Number($('#celluloseLayer :selected').val());
            product["innerLayer"] = Number($('#innerLayer :selected').val());
            product["faceLayer"] = Number($('#faceLayer :selected').val());
            product["cliche"] = $('#cliche').val();
            product["theoreticalSquare"] = $('#theoreticalSquare').val();
            product["actualSquare"] = $('#actualSquare').val();
            product["material"] = $('#material').val();
            product["format"] = Number($('#format :selected').val());
            product["sizeWorkpieceLength"] = $('#sizeWorkpieceLength').val();
            product["sizeWorkpieceWidth"] = $('#sizeWorkpieceWidth').val();
            product["numberFromSheet"] = $('#numberFromSheet').val();
            product["blankFormat"] = $('#blankFormat').val();
            product["connectionValve"] = Number($('#connectionValve :selected').val());
            product["stamp"] = $('#stamp').val();
            product["packing"] = Number($('#packing :selected').val());
            product["numberInPack"] = $('#numberInPack').val();
            product["numberInTransportPackage"] = $('#numberInTransportPackage').val();
            product["packageLength"] = $('#packageLength').val();
            product["packageWidth"] = $('#packageWidth').val();
            product["packageHeight"] = $('#packageHeight').val();
            product["pallet"] = Number($('#pallet :selected').val());
            product["palletPlacement"] = Number($('#palletPlacement :selected').val());
            product["palletRows"] = $('#palletRows').val();
            product["numberLoadCar"] = $('#numberLoadCar').val();
            product["productionFormat"] = $('#productionFormat').val();
            loadDataToServer();
        });

        function validationRequiredFields(){
            var value=$.trim($("#blankFormat").val());
            if (value.length === 0){
                alert("Формат заготовки не может быть пуст");
                return false;
            }
        }

        function loadDataToServer(){
            $.ajax({
                type: 'POST',
                url: '/products/newProduct/create',
                contentType: 'application/json',
                data: JSON.stringify(product),
                dataType: 'json'
            });
        }
    },

    __sumBigovki : function (){
        $(".sumBigovki").keyup(function() {
            var total = 0;
            $('.sumBigovki').each(function() {
                total = total + Number($(this).val());
            });
            $('input#sizeWorkpieceWidth').val(total);
        });
    },

    render: function () {
        return (
            <newProductContainer>
                <AppHeader />
                <AppBody />
            </newProductContainer>
        );
    }
});

ReactDOM.render(<App />, document.getElementById("newProductContainer"));