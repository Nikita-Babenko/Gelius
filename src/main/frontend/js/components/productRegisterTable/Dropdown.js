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
        this.__enableSortingStatus = this.__enableSortingStatus.bind(this);
        this.__enableFilteringStatus = this.__enableFilteringStatus.bind(this);
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
                    <Sorting columnName={this.props.columnName}/>
                    <Filtering columnName={this.props.columnName}
                               enableFiltering={this.__enableFilteringStatus}/>
                </div>
            </div>
        );
    }

    __enableSortingStatus(direction) {
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

    __disableSortingStatus() {
        this.setState({
            sortingAsc: false,
            sortingDesc: false
        });
    }

    __enableFilteringStatus(isEnabled) {
        this.setState({filteringEnabled: isEnabled});
    }

}

export default Dropdown;