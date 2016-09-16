import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import EventConstants from '../constants/Events';
import ObjectsConstants from '../constants/Objects';
import FilteringSortingActions from '../actions/FilteringSortingActions';

class FilteringSortingStore extends EventEmitter {

    constructor() {
        super();
        this.sortingFiltering = this.__getDefaultSortingFilteringObject();

        this.allFilterParameters = [];

        this.lastFilteredColumn = {
            name: "",
            parameters: []
        };

        this.sortableColumns = {
            previousSortableColumn: "",
            currentSortableColumn: ""
        };

        this.isSortingAction = false;
        this.isResetAll = false;
    }

    __getDefaultSortingFilteringObject() {
        return {
            "productNumber": [],
            "client.companyName": [],
            "productName": [],
            "productType.productType": [],
            "innerLength": [],
            "innerWidth": [],
            "innerHeight": [],
            "cardboardBrand.cardboardBrand": [],
            "profile.profile": [],
            "layersColours": [],
            "cliche": [],
            "sortableColumn": "productNumber",
            "sortingDirection": "asc"
        };
    };

    getFilterParametersForColumn(columnName) {
        var result = [];

        if (columnName !== this.lastFilteredColumn.name)
            result = this.__concatArrays(this.allFilterParameters[columnName], this.sortingFiltering[columnName]);
        else
            result = this.__concatArrays(this.lastFilteredColumn.parameters, this.sortingFiltering[columnName]);

        if ((this.sortingFiltering[columnName].length == 0)) {
            result = this.allFilterParameters[columnName];
        }

        return result

    }

    getSortingActionStatus() {
        return this.isSortingAction;
    }

    getSortingFilteringData() {
        return this.sortingFiltering;
    }

    getLastSortedColumn() {
        return this.sortableColumns.previousSortableColumn;
    }

    emitChange() {
        this.emit(EventConstants.FILTERING_SORTING_CHANGE_EVENT);
    }

    getIsResetAll() {
        return this.isResetAll;
    }

    __concatArrays(a, b) {
        return a.concat(b.filter(function (item) {
            return a.indexOf(item) < 0;
        }));
    }

    isAnyFilterSelected() {
        var isSelected = false;
        var filtering = this.sortingFiltering;
        for (var param in this.sortingFiltering) {
            if (Array.isArray(filtering[param]) && (filtering[param].length > 0)) {
                isSelected = true;
                break;
            }
        }
        return isSelected;
    }

}

const filteringSortingStore = new FilteringSortingStore();

filteringSortingStore.dispatchToken = Dispatcher.register(function (event) {
    switch (event.eventType) {
        case EventConstants.LOAD_ALL_FILTER_PARAMETERS:
            filteringSortingStore.allFilterParameters = event.parameters;
            filteringSortingStore.emitChange();
            break;
        case EventConstants.ADD_FILTER_ELEMENT:
            var filterParameters = filteringSortingStore.sortingFiltering[event.columnName];
            var lastColumn = filteringSortingStore.lastFilteredColumn;
            filterParameters.push(event.parameterValue);
            if (lastColumn.name !== event.columnName) {
                lastColumn.parameters = filteringSortingStore.allFilterParameters[event.columnName];
                lastColumn.name = event.columnName;
            }
            filteringSortingStore.isSortingAction = false;
            break;
        case EventConstants.DELETE_FILTER_ELEMENT:
            var filterParameters = filteringSortingStore.sortingFiltering[event.columnName];
            filterParameters.splice($.inArray(event.parameterValue, filterParameters), 1);
            filteringSortingStore.isSortingAction = false;
            break;
        case EventConstants.APPLY_SORTING:
            filteringSortingStore.sortingFiltering.sortableColumn = event.columnName;
            filteringSortingStore.sortingFiltering.sortingDirection = event.direction;
            filteringSortingStore.isSortingAction = true;
            filteringSortingStore.sortableColumns.previousSortableColumn = filteringSortingStore.sortableColumns.currentSortableColumn;
            filteringSortingStore.sortableColumns.currentSortableColumn = event.columnName;
            filteringSortingStore.emitChange();
            break;
        case EventConstants.RESET_ALL_FILTERS:
            filteringSortingStore.sortingFiltering = filteringSortingStore.__getDefaultSortingFilteringObject();
            filteringSortingStore.isResetAll = true;
            filteringSortingStore.emitChange();
            filteringSortingStore.isResetAll = false;
            break;
        case EventConstants.RESET_FILTERS_FOR_COLUMN:
            filteringSortingStore.sortingFiltering[event.columnName] = [];
            break;
        case EventConstants.SELECT_FILTERS_FOR_COLUMN:
            filteringSortingStore.sortingFiltering[event.columnName] = filteringSortingStore.allFilterParameters[event.columnName];
            break;

    }
});

export default filteringSortingStore;