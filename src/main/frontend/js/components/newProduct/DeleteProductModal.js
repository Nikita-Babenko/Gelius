import React from 'react';
import DeleteProductDialog from '../general/deleteModal/DeleteProductDialog';
import NewProductStore from '../../stores/NewProductStore';
import NewProductActions from '../../actions/NewProductActions';
import EventConstants from '../../constants/Events';

/**
 Delete model that appears on product (edit) page
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
        NewProductStore.addListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadProductId);
    }

    componentWillUnmount() {
        NewProductStore.removeListener(EventConstants.NEW_PRODUCT_CHANGE_EVENT, this.__loadProductId);
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
            NewProductActions.deleteProductById(id, true);
        }
    }

    __loadProductId() {
        this.setState({
            productId: NewProductStore.getProductProperty("id")
        });
    }
}