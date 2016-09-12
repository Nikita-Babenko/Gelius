import React from 'react';
import ProductRegisterStore from '../../stores/ProductRegisterStore';
import UrlConstants from '../../constants/Url';
import EventConstants from '../../constants/Events';

export default class ControlButtons extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            productId: null
        };

        this.__loadProductId = this.__loadProductId.bind(this);
    }

    componentDidMount() {
        ProductRegisterStore.addListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this.__loadProductId);
    }

    componentWillUnmount() {
        ProductRegisterStore.removeListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this.__loadProductId);
    }

    render() {
        var id = this.state.productId;
        return (
            <div className="col-md-5 col-xs-6 header_buttons icon_buttons_group">
                <a href={UrlConstants.CREATE_PRODUCT_URL}
                   className="fa fa-plus fa-2x"
                   title="Добавить новый продукт"
                   aria-hidden="true">
                </a>
                <a href={id ? UrlConstants.EDIT_PRODUCT_URL + id : "#"}
                   className="fa fa-pencil fa-2x"
                   title="Отредактировать продукт"
                   aria-hidden="true">
                </a>
                <a href="#"
                   className="fa fa-check fa-2x"
                   aria-hidden="true">
                </a>
                <a href={id ? UrlConstants.COPY_PRODUCT_URL + id : "#"}
                   className="fa fa-copy fa-2x"
                   title="Скопировать продукт"
                   aria-hidden="true">
                </a>
            </div>
        );
    }

    __loadProductId() {
        this.setState({
            productId: ProductRegisterStore.getSelectedProductId()
        });
    }
}

export default ControlButtons;