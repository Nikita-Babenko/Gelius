import React from 'react';

class HeaderRight extends React.Component{
    render(){
        return(
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
}

export default HeaderRight;
