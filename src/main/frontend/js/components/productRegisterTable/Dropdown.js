import React from 'react';
import FilteringSortingActions from '../../actions/FilteringSortingActions';
import FilteringSortingStore from '../../stores/FilteringSortingStore';
import EventConstants from '../../constants/Events';
import Sorting from '../productRegisterTable/Sorting';
import Filtering from '../productRegisterTable/Filtering';

class Dropdown extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            filteringEnabled: false,
            sortingAsc: this.props.columnName === 'ids',
            sortingDesc: false
        };
        this._enableSortingStatus = this._enableSortingStatus.bind(this);
        this._disableSortingStatus = this._disableSortingStatus.bind(this);
        this._enableFilteringStatus = this._enableFilteringStatus.bind(this);
    }

    componentDidMount() {
        FilteringSortingStore.addListener(EventConstants.FILTERING_SORTING_CHANGE_EVENT, this._disableSortingStatus);
    }

    componentWillUnmount() {
        FilteringSortingStore.removeListener(EventConstants.FILTERING_SORTING_CHANGE_EVENT, this._disableSortingStatus);
    }

    render() {
        var filterStatusClass = this.state.filteringEnabled ? 'display' : 'hide';
        var sortingStatusAsc = this.state.sortingAsc ? 'display' : 'hide';
        var sortingStatusDesc = this.state.sortingDesc ? 'display' : 'hide';

        return (
            <div className="dropdown">
                <button type="button" className="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown">
                    <i className=" fa fa-chevron-down "></i>
                    <sup>
                        <i className={"fa fa-filter " + filterStatusClass}
                           aria-hidden="true"/>
                        <i className={"fa fa-long-arrow-up " + sortingStatusAsc}
                           aria-hidden="true"/>
                        <i className={"fa fa-long-arrow-down " + sortingStatusDesc}
                           aria-hidden="true"/>
                    </sup>
                </button>
                <div className={"dropdown-menu  header-dropdown " + this.props.position}>
                    <Sorting columnName={this.props.columnName}
                             enableSorting={this._enableSortingStatus}/>
                    <Filtering columnName={this.props.columnName}
                               enableFiltering={this._enableFilteringStatus}/>
                </div>
            </div>
        );
    }

    _enableSortingStatus(direction) {
        if (direction === 'asc') {
            this.setState({
                sortingAsc: true,
                sortingDesc: false
            });
        } else {
            this.setState({
                sortingAsc: false,
                sortingDesc: true
            });
        }
    }

    _disableSortingStatus() {
        var isSortingAction = FilteringSortingStore.getSortingActionStatus();
        if (isSortingAction) {
            var lastSortedColumn = FilteringSortingStore.getLastSortedColumn();
            if ((this.props.columnName === lastSortedColumn) &&
                (this.state.sortingAsc || this.state.sortingDesc)) {
                this.setState({
                    sortingAsc: false,
                    sortingDesc: false
                });
            }
        }
    }

    _enableFilteringStatus(isEnabled) {
        this.setState({filteringEnabled: isEnabled});
    }

}

export default Dropdown;