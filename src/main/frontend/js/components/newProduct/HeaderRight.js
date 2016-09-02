import React from 'react';
import DatePicker from '../newProduct/DatePicker';
import EventConstants from '../../constants/Events';
import NewProductStore from '../../stores/NewProductStore';

class HeaderRight extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isUse: true
        };
        this.__changeCheckbox = this.__changeCheckbox.bind(this);
    }

    componentWillMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__setChecked);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__setChecked);
    }

    render() {
        return (
            <div className="col-lg-3 col-md-4 col-sm-5 col-xs-5 header_right">
                <div className="form-group form-inline create">
                    <p>Создано</p>
                    <DatePicker class="form-control" id="productCreateDate"/>
                </div>

                <div className="form-group form-inline update">
                    <p>Изменено</p>
                    <DatePicker class="form-control" id="productUpdateDate"/>
                </div>

                <div className="form-group form-inline do">
                    <p>Подготовил</p>
                    <input type="text" className="form-control" id="personPrepared"/>
                </div>

                <div className="form-group form-inline use">
                    <input type="checkbox" className="header_righ_checkbox" id="isUse" checked={this.state.isUse} onChange={this.__changeCheckbox}/>
                    <p>Тех.карта используется</p>
                </div>
            </div>
        );
    }

    __changeCheckbox(e) {
        var isUse = e.target.checked;
        this.setState({isUse: isUse});
    }

    __setChecked(){
        this.setState({isUse: NewProductStore.getIsNew()});
    }
}

export default HeaderRight;
