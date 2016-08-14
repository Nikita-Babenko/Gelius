import Dispatcher from '../dispatcher/Dispatcher';
import ProductsTableStore from '../stores/ProductRegisterTableStore';
import FilteringSortingStore from '../stores/FilteringSortingStore';
import UrlConstants from '../constants/Url';
import EventConstants from '../constants/Events';
import $ from 'jquery';

var ProductsTableActions = {

    loadProductsFromServer (){
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: UrlConstants.LOAD_PRODUCTS_URL,
            data: JSON.stringify(FilteringSortingStore.getSortingFilteringData()),
            dataType: 'json',
            timeout: 100000,
            success: (data) => {
                Dispatcher.dispatch({
                    eventType: EventConstants.LOAD_FILTERED_SORTED_PRODUCTS,
                    payload: data.result
                });
            },
            error: function () {
                Dispatcher.dispatch({
                    eventType: EventConstants.LOAD_FILTERED_SORTED_PRODUCTS,
                    payload: "Some error has happened during loading products!"
                });
            }
        });
    }

};

export default ProductsTableActions;