import React from 'react';
import FilteringSortingActions from '../../actions/FilteringSortingActions';
import FilteringSortingStore from '../../stores/FilteringSortingStore';
import EventConstants from '../../constants/Events';
import FilterElement from '../productRegisterTable/FilterElement';

class Filtering extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            filterData: [],
            filtersChecked: 0,
            searchString: ''
        };
        this._handleSearchChange = this._handleSearchChange.bind(this);
        this._onFilteringParametersDataUpdated = this._onFilteringParametersDataUpdated.bind(this);
        this._onFilteringParameterSelected = this._onFilteringParameterSelected.bind(this);
    }

    componentDidMount() {
        FilteringSortingStore.addListener(EventConstants.FILTERING_SORTING_CHANGE_EVENT, this._onFilteringParametersDataUpdated);
    }

    componentWillUnmount() {
        FilteringSortingStore.removeListener(EventConstants.FILTERING_SORTING_CHANGE_EVENT, this._onFilteringParametersDataUpdated);
    }

    render() {
        var filterData = this.state.filterData;
        var searchString = this.state.searchString.trim().toLowerCase();
        if (searchString.length > 0) {
            filterData = filterData.filter(function (d) {
                if (typeof d === 'number')
                    d = d + '';
                if (d !== null)
                    return d.toLowerCase().match(searchString);
            });
        }
        var columnName = this.props.columnName;
        var onFilterParameterSelected = this._onFilteringParameterSelected;
        var filterCheckboxes = filterData.map(function (e) {
            if (e !== null)
                return (
                    <FilterElement columnName={columnName}
                                   parameterSelected={onFilterParameterSelected}
                                   key={e}
                                   element={e}/>
                );
        });
        return (
            <div>
                <div className="dropdown-header">Фильтры</div>
                <div className="input-group filter-search">
                    <div className="input-group-addon">
                        <i className="fa fa-search"></i>
                    </div>
                    <input className="form-control" id="search" name="search" type="text"
                           value={this.state.searchString} onChange={this._handleSearchChange}/>
                </div>
                <div>
                    <ul className="scrollable-menu" role="menu">
                        {filterCheckboxes}
                    </ul>
                </div>
            </div>
        );
    }

    _handleSearchChange(e) {
        this.setState({
            searchString: e.target.value
        })
    }

    _onFilteringParameterSelected(state) {
        var newTotal = this.state.filtersChecked + (state ? 1 : -1);
        this.setState({filtersChecked: newTotal});
        this.props.enableFiltering(newTotal > 0);
    }

    _onFilteringParametersDataUpdated() {
        this.setState({
            filterData: FilteringSortingStore.getFilterParametersForColumn(this.props.columnName)
        });
    }

}

export default Filtering;