import Dispatcher from '../dispatcher/Dispatcher';
import FilteringSortingStore from '../stores/FilteringSortingStore';
import ProductRegisterActions from './ProductRegisterActions';
import UrlConstants from '../constants/Url';
import EventConstants from '../constants/Events';
import L from '../utils/Logging';

var FilteringSortingActions = {

    loadAllFilterParametersFromServer () {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: UrlConstants.LOAD_ALL_FILTER_PARAMETERS_URL,
            data: JSON.stringify(FilteringSortingStore.getSortingFilteringData()),
            dataType: 'json',
            timeout: 100000,
            success: (response) => {
                Dispatcher.dispatch({
                    eventType: EventConstants.LOAD_ALL_FILTER_PARAMETERS,
                    parameters: response.data
                });
            },
            error: (e) => {
                L.log("ERROR: ", e);
            }
        });
    },

    addFilterParameter(columnName, value) {
        Dispatcher.dispatch({
            eventType: EventConstants.ADD_FILTER_ELEMENT,
            columnName: columnName,
            parameterValue: value
        });
        this.loadAllFilterParametersFromServer ();
    },

    deleteFilterParameter(columnName, value) {
        Dispatcher.dispatch({
            eventType: EventConstants.DELETE_FILTER_ELEMENT,
            columnName: columnName,
            parameterValue: value
        });
        this.loadAllFilterParametersFromServer ();
    },

    applySorting(columnName, sortingDirection) {
        Dispatcher.dispatch({
            eventType: EventConstants.APPLY_SORTING,
            columnName: columnName,
            direction: sortingDirection
        });
    },

    resetAllFilters() {
        Dispatcher.dispatch({
            eventType: EventConstants.RESET_ALL_FILTERS
        });
        this.loadAllFilterParametersFromServer ();
        ProductRegisterActions.loadProductsFromServer();
    },

    resetAllFiltersForColumn(columnName){
        Dispatcher.dispatch({
            eventType: EventConstants.RESET_FILTERS_FOR_COLUMN,
            columnName: columnName
        });
        this.loadAllFilterParametersFromServer ();
        ProductRegisterActions.loadProductsFromServer();
    },

    selectAllFiltersForColumn(columnName){
        Dispatcher.dispatch({
            eventType: EventConstants.SELECT_FILTERS_FOR_COLUMN,
            columnName: columnName
        });
        this.loadAllFilterParametersFromServer ();
        ProductRegisterActions.loadProductsFromServer();
    }

};

export default FilteringSortingActions;