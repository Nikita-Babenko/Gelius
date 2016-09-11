import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import EventConstants from '../constants/Events';

class ProductsTableStore extends EventEmitter {

    constructor() {
        super();
        this.products = [];
        this.previousSelectedProductId = null;
        this.selectedProductId = null;
    }

    emitChange() {
        this.emit(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT);
    }

    getPreviousSelectedProductId() {
        return this.previousSelectedProductId;
    }

    getSelectedProductId() {
        return this.selectedProductId;
    }

    getProductsTableData() {
        return this.products;
    }

}

const productsTableStore = new ProductsTableStore();

productsTableStore.dispatchToken = Dispatcher.register(function(event) {
    switch (event.eventType) {

        case EventConstants.LOAD_FILTERED_SORTED_PRODUCTS:
            productsTableStore.products = event.payload;
            productsTableStore.emitChange();
            break;
        case EventConstants.SELECT_PRODUCT:
            productsTableStore.previousSelectedProductId = productsTableStore.selectedProductId;
            productsTableStore.selectedProductId = event.productId;
            productsTableStore.emitChange();
            if (productsTableStore.previousSelectedProductId === productsTableStore.selectedProductId)
                productsTableStore.previousSelectedProductId = productsTableStore.selectedProductId = null;
            break;
        default:
        // Do nothing

    }
});

export default productsTableStore;