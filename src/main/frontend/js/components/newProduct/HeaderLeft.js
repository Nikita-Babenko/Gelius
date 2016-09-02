import React from "react";
import Dictionary from "../newProduct/Dictionary";
import ProductNumberInput from "../newProduct/ProductNumberInput";
import NewProductActions from '../../actions/NewProductActions';

class HeaderLeft extends React.Component {
    render() {
        return (
            <div className="col-lg-9 col-md-8 col-sm-7 col-xs-7 header_left">
                <div className="col-md-12 header_top">
                    <div className="col-md-5 col-xs-10 col-sm-11  header_buttons icon_buttons_group">
                        <a href="/products/register" className="fa fa-arrow-left fa-2x" title="На страницу реестра" aria-hidden="true"/>

                        <a href="#"
                           className="fa fa-floppy-o fa-2x"
                           title="Сохранить продукт"
                           aria-hidden="true"
                           onClick={this.__onSaveNewProductButtonClick}
                        />

                        <a href="#" className="fa fa-trash-o fa-2x" title="Удалить продук" aria-hidden="true"/>

                        <a href="#" className="fa fa-file-pdf-o fa-2x" aria-hidden="true"/>

                        <a href="#" className="fa-2x fa-stack">
                            <i className="fa fa-file-pdf-o fa-stack-1x" id="stacked_pdf_icon"></i>
                            <i className="fa fa-user fa-stack-1x" id="stacked_user_icon"></i>
                        </a>

                    </div>

                    <div className="col-md-7 col-xs-10 col-sm-11 header_title">
                        <div className="header_title_text">
                            <p>
                                Новая техкарта №
                            </p>
                        </div>
                        <ProductNumberInput />
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
                            <input type="text" className="form-control header_info_name" id="productName"/>
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

    __onSaveNewProductButtonClick() {
        NewProductActions.saveProduct();
    }
}

export default HeaderLeft;