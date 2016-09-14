import React from "react";
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
                            <label for="Customer">Заказчик</label>
                            <Dictionary
                                dictionaryName="client"
                                dictionaryTextName="companyName"
                                style="form-control header_info_customer"
                            />
                        </div>

                        <div className="form-group col-xs-12 col-sm-10 col-md-6 col-lg-4">
                            <label for="Name">Название</label>
                            <TextInput id="productName" style="form-control header_info_name"/>
                        </div>

                        <div className="form-group col-xs-12 col-sm-10 col-md-6 col-lg-4">
                            <label for="Type">Тип изделия</label>
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