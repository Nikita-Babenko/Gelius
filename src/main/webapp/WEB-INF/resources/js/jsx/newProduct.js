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
            <div className="col-lg-9 col-md-8 col-sm-8 col-xs-7 header_left">

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

                    <div className="col-md-7 header_title">
                        <div className="header_title_text">
                            <p>
                                Новая техкарта №
                            </p>
                        </div>
                        <div className="header_title_input">
                            <input type="text" className="form-control" contenteditable="false" />
                        </div>
                    </div>

                </div>

                <div className="col-md-12 header_down">

                    <div className="form-inline header_info">
                        <div className="form-group col-xs-12 col-sm-8 col-md-4 col-lg-4">
                            <label for="Customer">Заказчик</label>

                            <Select
                                className="form-control header_info_customer"
                                name="customer"
                                id="Customer"
                                ref="client"
                            />

                        </div>

                        <div className="form-group col-xs-12 col-sm-8 col-md-4 col-lg-4">
                            <label for="Name">Название</label>
                            <input type="text" className="form-control header_info_name" id="Name" />
                        </div>


                        <div className="form-group col-xs-12 col-sm-8 col-md-4 col-lg-4">
                            <label for="Type">Тип изделия</label>
                            <select className="form-control header_info_type" id="Type">
                                <option></option>
                                <option>Type1</option>
                                <option>Type2</option>
                                <option>Type3</option>
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
            <div className="col-lg-3 col-md-4 col-sm-4 col-xs-5 header_right">
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
                            <td className="products_small_td" >
                                <input type="text" />
                            </td>
                            <td className="products_large_td" >
                                <input type="text" />
                            </td>
                            <td className="products_small_td" >
                                <input type="text" />
                            </td>
                        </tr>

                        <tr>
                            <td className="products_large_td">S теор.</td>
                            <td className="products_small_td" >
                                <input  type="text" />
                            </td>
                            <td className="products_large_td">S факт.</td>
                            <td className="products_small_td" >
                                <input type="text" />
                            </td>
                        </tr>

                        <tr>
                            <td className="products_large_td">Расчетный формат</td>
                            <td className="products_small_td">
                                <select>
                                    <option></option>
                                    <option>Text1</option>
                                    <option>Text2</option>
                                    <option>Text3</option>
                                </select>
                            </td>
                            <td className="products_large_td">Профиль</td>
                            <td className="products_small_td">
                                <select>
                                    <option></option>
                                    <option>Text1</option>
                                    <option>Text2</option>
                                    <option>Text3</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td className="products_large_td">Марка картона</td>
                            <td className="products_small_td">
                                <select>
                                    <option></option>
                                    <option>Text1</option>
                                    <option>Text2</option>
                                    <option>Text3</option>
                                </select>
                            </td>
                            <td className="products_large_td">Целлюлозный слой</td>
                            <td className="products_small_td">
                                <select>
                                    <option></option>
                                    <option>Text1</option>
                                    <option>Text2</option>
                                    <option>Text3</option>
                                </select>
                            </td>
                        </tr>


                        <tr>
                            <td className="products_large_td">Лицевой слой</td>
                            <td className="products_small_td">
                                <select>
                                    <option></option>
                                    <option>Text1</option>
                                    <option>Text2</option>
                                    <option>Text3</option>
                                </select>
                            </td>
                            <td className="products_large_td">Внутренний слой</td>
                            <td className="products_small_td">
                                <select>
                                    <option></option>
                                    <option>Text1</option>
                                    <option>Text2</option>
                                    <option>Text3</option>
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
                                    <input type="text" className="input_1" />
                                    <input type="text" className="input_2" />
                                </div>
                            </td>

                        </tr>

                        <tr>
                            <td className="middle_products_large_td">Количество с листа</td>
                            <td className="middle_products_small_td">
                                <input type="text" />
                            </td>
                        </tr>

                        <tr>
                            <td className="middle_products_large_td">Формат заготовки</td>
                            <td className="middle_products_small_td">
                                <input type="text" />
                            </td>
                        </tr>

                        <tr>
                            <td className="middle_products_large_td">Соединение клапана</td>
                            <td className="middle_products_small_td">
                                <select>
                                    <option></option>
                                    <option>Text1</option>
                                    <option>Text2</option>
                                    <option>Text3</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td className="middle_products_large_td">Штамп</td>
                            <td className="middle_products_small_td">
                                <input type="text" />
                            </td>
                        </tr>

                        <tr>
                            <td className="middle_products_large_td">Клише</td>
                            <td className="middle_products_small_td">
                                <input type="text" />
                            </td>
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
                                <select>
                                    <option></option>
                                    <option>Без упаковки</option>
                                    <option>Паллета, лента, стрейч</option>
                                    <option>Паллета, лента, без стрейча</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td className="avto_large_td">В пачке, шт.</td>
                            <td className="avto_small_td">
                                <input type="text" />
                            </td>
                        </tr>

                        <tr>
                            <td className="avto_large_td">В транспортном пакете, шт.</td>
                            <td className="avto_small_td">
                                <input type="text" />
                            </td>
                        </tr>

                        <tr>
                            <td className="avto_large_td">
                                Размеры пакета
                                <input className="embeded_input" type="text"/>
                            </td>
                            <td className="avto_small_td">
                                <div className="inputs">
                                    <input type="text" className="input_1" />
                                    <input type="text" className="input_2" />
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td className="avto_large_td">Поддон</td>
                            <td className="avto_small_td">
                                <select>
                                    <option></option>
                                    <option>1200x800</option>
                                    <option>1200x1000</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                            <td className="avto_large_td">Размещение на поддоне</td>
                            <td className="avto_small_td">
                                <select>
                                    <option></option>
                                    <option>1 пачка в ряду</option>
                                    <option>2 пачки в ряду</option>
                                    <option>3 пачки в ряду</option>
                                </select>
                            </td>
                        </tr>


                        <tr>
                            <td className="avto_large_td">Рядов на поддоне</td>
                            <td className="avto_small_td">
                                <input type="text" />
                            </td>
                        </tr>

                        <tr>
                            <td className="avto_large_td">Загрузка автомобиля, шт.</td>
                            <td className="avto_small_td">
                                <input type="text" />
                            </td>
                        </tr>

                        <tr>
                            <td colSpan="3" className="attachments">
                                <div className="links">
                                    <a href="#">тех.карта.pdf</a>
                                    <br/>
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
                                    <input type="text" className="bigovki_input_1"/>
                                    <input type="text" className="bigovki_input_2" value="+" disabled/>
                                </div>
                                <div className="bigovki_inputs_2">
                                    <input type="text" className="bigovki_input_1"/>
                                    <input type="text" className="bigovki_input_2" value="+" disabled/>
                                </div>
                                <div className="bigovki_inputs_3">
                                    <input type="text" className="bigovki_input_3" />
                                    <input type="text" className="bigovki_input_4" />
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td className="avto_large_td" colSpan="2">Производственный формат</td>
                            <td className="avto_small_td">
                                <input type="text" />
                            </td>
                        </tr>

                        <tr>
                            <td colSpan="3" className="right_table_title green_color">
                                Просечки
                            </td>
                        </tr>

                        <tr>
                            <td colSpan="3" className="prosechki_all">
                                <div className="prosechki_inputs">
                                    <input type="text" className="prosechki_input_1"/>
                                    <input type="text" className="prosechki_input_2"/>
                                    <input type="text" className="prosechki_input_3"/>
                                    <input type="text" className="prosechki_input_4"/>
                                    <input type="text" className="prosechki_input_5"/>
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

var Select = React.createClass({
    getInitialState: function () {
       return {
            opts: [],
            value: '',
            data: {}
        }
    },
    __fillOptions: function () {

        var init = [ { id: 'one', str: 'One' },
            { id: 'two', str: 'Two' } ]

        this.setState({opts: init});

        console.log(this.state.opts);

        var data = this.state.data;

        console.log(data);

        for (var i = 0; i < data.length; i++) {
            var option = data[i];
            this.state.opts.push(
                <option key={i} value={option.value}>{option.name}</option>
            );
        }
        this.forceUpdate();
    },
    componentDidMount: function () {
        this.__fillOptions();
    },
    __onChange: function () {

    },
    render: function () {
        return (
            <select className={this.props.className}
                name={this.props.name}
                id={this.props.id}
                onChange={this.__onChange} ref={this.props.ref}>
                {this.state.opts}
            </select>
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
        return {dictionaries: {}}
    },
    componentDidMount: function () {
        this.__getAllDictionaries();
        this.__setAllDictionaries();
    },
    __getAllDictionaries: function () {
        $.ajax({
            type: 'get',
            contentType: "application/json",
            url: "/dictionaries/all",
            data: '',
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                this.setState({dictionaries: data.result});
            }.bind(this),
            error: function (e) {
                console.log("ERROR: ", e);
            }.bind(this)
        });
    },

    __setAllDictionaries: function() {
      this.refs.client.setState({data: dictionaries.client});
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