import React from "react";
import Select from "react-select";
import DictionaryStore from "../../stores/DictionariesStore";
import EventConstants from "../../constants/Events";
import NewProductStore from "../../stores/NewProductStore";
import Dictionary from "../newProduct/Dictionary";
import ProductNumberInput from "../newProduct/ProductNumberInput";
import TextInput from "../newProduct/TextInput";
import HeaderControlButtons from "../newProduct/HeaderControlButtons";

class HeaderLeft extends React.Component {
    render() {
        return (
            <div className="col-lg-9 col-md-8 col-sm-7 col-xs-7 header_left">
                <div className="col-md-12 header_top">
                    <HeaderControlButtons/>

                    <div className="col-md-7 col-xs-10 col-sm-11 header_title">
                        <div className="header_title_text">
                            <p>
                                Новая техкарта №
                            </p>
                        </div>
                        <ProductNumberInput/>
                    </div>
                </div>

                <div className="col-md-12 header_down">
                    <div className="form-inline header_info">
                        <div className="form-group col-xs-12 col-sm-10 col-md-6 col-lg-4">
                            <label className="header_info_customer_label">Заказчик</label>
                            <ClientsSelect/>
                        </div>

                        <div className="form-group col-xs-12 col-sm-10 col-md-6 col-lg-4">
                            <label>Название</label>
                            <TextInput id="productName" style="form-control header_info_name"/>
                        </div>

                        <div className="form-group col-xs-12 col-sm-10 col-md-6 col-lg-4">
                            <label>Тип изделия</label>
                            <Dictionary
                                dictionaryName="productType"
                                dictionaryTextName="productType"
                                style="form-control header_info_type"
                            />
                        </div>

                    </div>
                </div>
            </div>
        );
    }

}

export default HeaderLeft;

class ClientsSelect extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            value: "",
            clients: []
        };
        this.__loadDefaultValue = this.__loadDefaultValue.bind(this);
        this._onDictionariesParametersUpdated = this._onDictionariesParametersUpdated.bind(this);
    }

    componentWillMount() {
        DictionaryStore.addListener(EventConstants.DICTIONARIES_CHANGE_EVENT, this._onDictionariesParametersUpdated);
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    componentWillUnmount() {
        DictionaryStore.removeListener(EventConstants.DICTIONARIES_CHANGE_EVENT, this._onDictionariesParametersUpdated);
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadDefaultValue);
    }

    render() {
        var options = [
            {value: '', label: 'не выбран'}
        ];

        $.each(this.state.clients, function (index, client) {
            options.push({value: client.id, label: client.companyName});
        });

        return (
            <Select
                className="form-control header_info_customer"
                name="client"
                value={this.state.value}
                options={options}
                placeholder={"не выбран"}
                noResultsText={"нет подходящих вариантов"}
                onChange={this.onClientChange.bind(this)}
                clearable={false}
            />
        );
    }

    onClientChange(val) {
        this.setState({value: val.value});
    }

    _onDictionariesParametersUpdated() {
        this.setState({
            clients: DictionaryStore.getDictionaryParameters("client")
        });
    }

    __loadDefaultValue() {
        if (NewProductStore.isEnableDefaultValues()) {
            var clientValue = NewProductStore.getProductProperty("client");
            this.setState({
                value: clientValue ? clientValue.id : ''
            });
        }
    }
}