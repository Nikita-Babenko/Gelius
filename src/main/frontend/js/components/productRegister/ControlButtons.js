import React from 'react';
import ReactDOM from "react-dom";
import ProductRegisterStore from '../../stores/ProductRegisterStore';
import FilteringSortingStore from '../../stores/FilteringSortingStore';
import UrlConstants from '../../constants/Url';
import EventConstants from '../../constants/Events';
import NewProductActions from '../../actions/NewProductActions';
import FilteringSortingActions from '../../actions/FilteringSortingActions';
import DeleteModal from '../general/DeleteModal';

class ControlButtons extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            productId: null,
            isAnyFilterSelected: false
        };

        this.__loadProductId = this.__loadProductId.bind(this);
        this.__isAnyFilterSelected = this.__isAnyFilterSelected.bind(this);
        this.__onDiscardAllFiltersButtonClick = this.__onDiscardAllFiltersButtonClick.bind(this);
        this.__onDeleteProductButtonClick = this.__onDeleteProductButtonClick.bind(this);
        this._deleteFunction = this._deleteFunction.bind(this);
    }

    componentDidMount() {
        ProductRegisterStore.addListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this.__loadProductId);
        FilteringSortingStore.addListener(EventConstants.FILTERING_SORTING_CHANGE_EVENT, this.__isAnyFilterSelected);
    }

    componentWillUnmount() {
        ProductRegisterStore.removeListener(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT, this.__loadProductId);
        FilteringSortingStore.removeListener(EventConstants.FILTERING_SORTING_CHANGE_EVENT, this.__isAnyFilterSelected);
    }

    render() {
        var id = this.state.productId;
        var disableCopyDeleteButtons = id ? "" : " disabled";
        var disableResetFiltersButton = this.state.isAnyFilterSelected ? "" : " disabled";

        return (
            <div className="col-md-5 col-xs-6 header_buttons icon_buttons_group">
                <a href={UrlConstants.CREATE_PRODUCT_URL}
                   className="control-btn btn fa fa-plus fa-2x"
                   title="Добавить новый продукт"
                   aria-hidden="true">
                </a>
                <a href={id ? UrlConstants.EDIT_PRODUCT_URL + id : "#"}
                   className={"control-btn btn fa fa-pencil fa-2x" + disableCopyDeleteButtons}
                   title="Отредактировать продукт"
                   aria-hidden="true">
                </a>
                <a href={id ? UrlConstants.COPY_PRODUCT_URL + id : "#"}
                   className={"control-btn-slide btn fa fa-files-o fa-2x" + disableCopyDeleteButtons}
                   title="Скопировать продукт"
                   aria-hidden="true">
                </a>
                <a className={"control-btn-slide btn fa fa-filter fa-2x" + disableResetFiltersButton}
                   title="Отменить все фильтры"
                   aria-hidden="true"
                   onClick={this.__onDiscardAllFiltersButtonClick}>
                </a>
                <a className={"control-btn btn fa fa-trash-o fa-2x" + disableCopyDeleteButtons}
                   title="Удалить продукт"
                   aria-hidden="true"
                   onClick={this.__onDeleteProductButtonClick}>
                </a>
                <DeleteModal ref="deleteRegisterProductModal"
                             confirmMessage="Вы уверены, что хотите удалить техническую карту?"
                             deleteFunction={this._deleteFunction}
                />
            </div>
        );
    }

    __loadProductId() {
        this.setState({
            productId: ProductRegisterStore.getSelectedProductId()
        });
    }

    __isAnyFilterSelected() {
        this.setState({
            isAnyFilterSelected: FilteringSortingStore.isAnyFilterSelected()
        })
    }

    __onDiscardAllFiltersButtonClick() {
        FilteringSortingActions.resetAllFilters();
    }

    __onDeleteProductButtonClick() {
        if (this.state.productId)
            $(ReactDOM.findDOMNode(this.refs.deleteRegisterProductModal)).modal();
    }

    _deleteFunction() {
        NewProductActions.deleteProductById(this.state.productId, false)
    }


}

export default ControlButtons;