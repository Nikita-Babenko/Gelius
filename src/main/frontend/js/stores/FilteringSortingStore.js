import EventEmitter from 'eventemitter3';
import Dispatcher from '../dispatcher/Dispatcher';
import EventConstants from '../constants/Events';
import ObjectsConstants from '../constants/Objects';
import FilteringSortingActions from '../actions/FilteringSortingActions';

class FilteringSortingStore extends EventEmitter {

    constructor() {
        super();
        this.sortingFiltering = {
            id: [],
            "client.companyName": [],
            productName: [],
            "productType.productType": [],
            innerLength: [],
            innerWidth: [],
            innerHeight: [],
            "cardboardBrand.cardboardBrand": [],
            "profile.profile": [],
            layersColours: [],
            cliche: [],
            sortableColumn: "id",
            sortingDirection: "asc"
        };

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
    }

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

    onChange(listener, context) {
        this.on(EventConstants.FILTERING_SORTING_CHANGE_EVENT, listener, context);
    }

    offChange(listener, context) {
        this.removeListener(EventConstants.FILTERING_SORTING_CHANGE_EVENT, listener, context);
    }

    emitChange() {
        this.emit(EventConstants.FILTERING_SORTING_CHANGE_EVENT);
    }

    __concatArrays(a, b) {
        return a.concat(b.filter(function (item) {
            return a.indexOf(item) < 0;
        }));
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
    }
});

export default filteringSortingStore;