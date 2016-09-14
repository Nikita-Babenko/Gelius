import React from 'react';
import ReactDOM from "react-dom";
import ProductRegisterStore from '../../stores/ProductRegisterStore';
import UrlConstants from '../../constants/Url';
import EventConstants from '../../constants/Events';
import NewProductActions from '../../actions/NewProductActions';
import DeleteProductModal from './DeleteProductModal';

export default class ControlButtons extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            productId: null
        };

        this.__loadProductId = this.__loadProductId.bind(this);
        this.__onDeleteProductButtonClick = this.__onDeleteProductButtonClick.bind(this);
    }

    componentDidMount() {
        ProductRegisterStore.addListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this.__loadProductId);
    }

    componentWillUnmount() {
        ProductRegisterStore.removeListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this.__loadProductId);
    }

    render() {
        var id = this.state.productId;
        var disableClass = id ? "" : " disabled";
        return (
            <div className="col-md-5 col-xs-6 header_buttons icon_buttons_group">
                <a href={UrlConstants.CREATE_PRODUCT_URL}
                   className="control-btn btn fa fa-plus fa-2x"
                   title="Добавить новый продукт"
                   aria-hidden="true">
                </a>
                <a href={id ? UrlConstants.EDIT_PRODUCT_URL + id : "#"}
                   className={"control-btn btn fa fa-pencil fa-2x" + disableClass}
                   title="Отредактировать продукт"
                   aria-hidden="true">
                </a>
                <a href="#"
                   className={"control-btn btn fa fa-trash-o fa-2x" + disableClass}
                   title="Удалить продукт"
                   aria-hidden="true"
                   onClick={this.__onDeleteProductButtonClick}>
                </a>
                <DeleteProductModal ref="deleteRegisterProductModal"/>

                <a href={id ? UrlConstants.COPY_PRODUCT_URL + id : "#"}
                   className={"control-btn-slide btn fa fa-files-o fa-2x" + disableClass}
                   title="Скопировать продукт"
                   aria-hidden="true">
                </a>
            </div>
        );
    }

    __onDeleteProductButtonClick() {
        if (this.state.productId)
            $(ReactDOM.findDOMNode(this.refs.deleteRegisterProductModal)).modal();
    }

    __loadProductId() {
        this.setState({
            productId: ProductRegisterStore.getSelectedProductId()
        });
    }
}

export default ControlButtons;