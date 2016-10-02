import React from 'react';
import ReactDOM from "react-dom";
import EventConstants from '../../constants/Events';
import NewProductActions from '../../actions/NewProductActions';
import NewProductStore from '../../stores/NewProductStore';
import DeleteModal from '../general/DeleteModal';
import UrlConstants from '../../constants/Url';

class HeaderControlButtons extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            productId: null
        };

        this.__loadProductId = this.__loadProductId.bind(this);
        this.__onDeleteProductButtonClick = this.__onDeleteProductButtonClick.bind(this);
        this._deleteFunction = this._deleteFunction.bind(this);
    }

    componentDidMount() {
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadProductId);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadProductId);
    }

    render() {
        var disableClass = this.state.productId ? "" : " disabled";
        return (
            <div className="col-md-5 col-xs-10 col-sm-11  header_buttons icon_buttons_group">
                <a href={UrlConstants.PRODUCT_REGISTER_PAGE}
                   className="fa fa-arrow-left fa-2x"
                   title="На страницу реестра"
                   tabIndex="-1"
                   aria-hidden="true"/>

                <a href="#"
                   className="fa fa-floppy-o fa-2x"
                   title="Сохранить продукт"
                   aria-hidden="true"
                   tabIndex="-1"
                   onClick={this.__onSaveProductButtonClick}/>

                <a className={"control-btn btn fa fa-trash-o fa-2x" + disableClass}
                   title="Удалить продукт"
                   aria-hidden="true"
                   tabIndex="-1"
                   onClick={this.__onDeleteProductButtonClick}/>
                <DeleteModal ref="deleteProductModal"
                             confirmMessage="Вы уверены, что хотите удалить техническую карту?"
                             deleteFunction={this._deleteFunction}
                />

                <a href={UrlConstants.DOWNLOAD_FULL_PRODUCT_PDF + this.state.productId} target="_blank"
                   title="Загрузить техническую карту для менеджера"
                   className={"control-btn btn fa fa-file-pdf-o fa-2x"  + disableClass}
                   tabIndex="-1"
                   aria-hidden="true"/>

                <a href={UrlConstants.DOWNLOAD_SHORT_PRODUCT_PDF + this.state.productId} target="_blank"
                   title="Загрузить техническую карту для клиента"
                   tabIndex="-1"
                   className={"control-btn btn fa-2x fa-stack"  + disableClass}>
                    <i className="fa fa-file-pdf-o fa-stack-1x" id="stacked_pdf_icon"></i>
                    <i className="fa fa-user fa-stack-1x" id="stacked_user_icon"></i>
                </a>

            </div>
        );
    }

    __onSaveProductButtonClick() {
        NewProductActions.saveProduct();
    }

    __onDeleteProductButtonClick() {
        if (this.state.productId)
            $(ReactDOM.findDOMNode(this.refs.deleteProductModal)).modal();
    }

    _deleteFunction() {
        NewProductActions.deleteProductById(this.state.productId, true)
    }

    __loadProductId() {
        if (NewProductStore.isInEditMode()) {
            this.setState({
                productId: NewProductStore.getProductProperty("id")
            });
        } else
            this.setState({
                productId: null
            });
    }
}

export default HeaderControlButtons;