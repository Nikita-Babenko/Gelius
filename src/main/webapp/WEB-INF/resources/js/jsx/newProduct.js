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
                            <input type="text" className="form-control" id="productNumber" contenteditable="false" />
                            <div className="isNew">
                                <input type="checkbox" />
                                <p>Новая Карта</p>
                            </div>
                        </div>
                    </div>

                </div>

                <div className="col-md-12 header_down">

                    <div className="form-inline header_info">
                        <div className="form-group col-xs-12 col-sm-8 col-md-6 col-lg-4">
                            <label for="Customer">Заказчик</label>
                            <select className="form-control header_info_customer" id="customer">

                            </select>
                        </div>

                        <div className="form-group col-xs-12 col-sm-8 col-md-6 col-lg-4">
                            <label for="Name">Название</label>
                            <input type="text" className="form-control header_info_name" id="Name" />
                        </div>


                        <div className="form-group col-xs-12 col-sm-8 col-md-6 col-lg-4">
                            <label for="Type">Тип изделия</label>
                            <select className="form-control header_info_type" id="type">

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
                    <input type="date" className="form-control" />
                </div>

                <div className="form-group form-inline update">
                    <p>Изменено</p>
                    <input type="date" className="form-control" />
                </div>

                <div className="form-group form-inline do">
                    <p>Подготовил</p>
                    <input type="text" className="form-control" />
                </div>

                <div className="form-group form-inline use">
                    <input type="checkbox" className="header_righ_checkbox" />
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
                        <td className="products_small_td" ><input type="number" /></td>
                        <td className="products_large_td" ><input type="number" /></td>
                        <td className="products_small_td" ><input type="number" /></td>
                    </tr>

                    <tr>
                        <td className="products_large_td">S теор.</td>
                        <td className="products_small_td" ><input  type="number" /></td>
                        <td className="products_large_td">S факт.</td>
                        <td className="products_small_td" ><input type="number" /></td>
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
                        <textarea>

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
                                <input type="number" className="input_1" />
                                <input type="number" className="input_2" />
                            </div>
                        </td>

                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Количество с листа</td>
                        <td className="middle_products_small_td"><input type="number" /></td>
                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Формат заготовки</td>
                        <td className="middle_products_small_td"><input type="number" required/></td>
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
                        <td className="middle_products_small_td"><input type="text" /></td>
                    </tr>

                    <tr>
                        <td className="middle_products_large_td">Клише</td>
                        <td className="middle_products_small_td"><input type="text" /></td>
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
                        <td className="avto_small_td"><input type="number" /></td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">В транспортном пакете, шт.</td>
                        <td className="avto_small_td"><input type="number" /></td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">
                            Размеры пакета
                            <input className="embeded_input" type="number"/>
                        </td>
                        <td className="avto_small_td">
                            <div className="inputs">
                                <input type="number" className="input_1" />
                                <input type="number" className="input_2" />
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
                        <td className="avto_small_td"><input type="number" /></td>
                    </tr>

                    <tr>
                        <td className="avto_large_td">Загрузка автомобиля, шт.</td>
                        <td className="avto_small_td"><input type="number" /></td>
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
                                <input type="number" className="bigovki_input_1"/>
                                <input type="text" className="bigovki_input_2" value="+" disabled/>
                            </div>
                            <div className="bigovki_inputs_2">
                                <input type="number" className="bigovki_input_1"/>
                                <input type="text" className="bigovki_input_2" value="+" disabled/>
                            </div>
                            <div className="bigovki_inputs_3">
                                <input type="number" className="bigovki_input_3" />
                                <input type="number" className="bigovki_input_4" />
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td className="avto_large_td" colSpan="2">Производственный формат</td>
                        <td className="avto_small_td"><input type="text" /></td>
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
                        <a className="fa fa-plus fa-3x" href="#">
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
                log("get init : response : " + JSON.stringify(response.data));
                this.setState({
                    dictionaries: response.data.dictionaries
                });

                $('#productNumber').val(response.data.productNumber);

                this.__setAllDictionaries();

            }.bind(this),
            error: function (e) {
                console.log("ERROR: ", e);
            }.bind(this)
        });
    },

    __setAllDictionaries: function () {
        var data = this.state.dictionaries;

        // client
        this.__fillOptions("customer", data.client, "companyName");

        // type
        this.__fillOptions("type", data.productType, "productType");

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