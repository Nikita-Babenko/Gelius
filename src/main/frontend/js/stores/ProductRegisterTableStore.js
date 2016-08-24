import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import EventConstants from '../constants/Events';

class ProductsTableStore extends EventEmitter {

    constructor() {
        super();
        this.products = [];
    }

    getProductsTableData() {
        return this.products;
    }

    emitChange() {
        this.emit(EventConstants.PRODUCTS_TABLE_CHANGE_EVENT);
    }

}

const productsTableStore = new ProductsTableStore();

productsTableStore.dispatchToken = Dispatcher.register(function(event) {
    switch (event.eventType) {

        case EventConstants.LOAD_FILTERED_SORTED_PRODUCTS:
            productsTableStore.products = event.payload;
            productsTableStore.emitChange();
            break;


        default:
        // Do nothing

    }
});

export default productsTableStore;