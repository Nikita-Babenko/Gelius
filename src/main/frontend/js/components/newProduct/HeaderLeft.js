import React from 'react';

class HeaderLeft extends React.Component{
    render(){
        return(
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
}

export default HeaderLeft;