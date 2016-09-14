import React from 'react';
import DeleteProductDialog from '../general/deleteModal/DeleteProductDialog';
import ProductRegisterStore from '../../stores/ProductRegisterStore';
import NewProductActions from '../../actions/NewProductActions';
import ProductRegisterActions from '../../actions/ProductRegisterActions';
import EventConstants from '../../constants/Events';

/**
 Delete model that appears on register page
 */
class DeleteProductModal extends React.Component {
    render() {
        return (
            <DeleteProductDialog>
                <ProductDeletionControls/>
            </DeleteProductDialog>
        );
    }
}

export default DeleteProductModal;

class ProductDeletionControls extends React.Component {

    constructor(props) {
        super(props);

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
        return (
            <div className="row text-center">
                <button type="button"
                        className="btn modal-btn "
                        data-dismiss="modal"
                        onClick={this.__onDeleteProductButtonClick}>
                    Удалить
                </button>
                <button type="button"
                        className="btn modal-btn"
                        data-dismiss="modal">
                    Отменить
                </button>
            </div>
        );
    }

    __onDeleteProductButtonClick() {
        var id = this.state.productId;
        if (id) {
            NewProductActions.deleteProductById(id, false);
            ProductRegisterActions.selectProduct(id);
        }
    }

    __loadProductId() {
        this.setState({
            productId: ProductRegisterStore.getSelectedProductId()
        });
    }
}