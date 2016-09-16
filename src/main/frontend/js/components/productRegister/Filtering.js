import React from 'react';
import FilteringSortingActions from '../../actions/FilteringSortingActions';
import FilteringSortingStore from '../../stores/FilteringSortingStore';
import EventConstants from '../../constants/Events';
import FilterElement from '../productRegister/FilterElement';

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
        this._resetAllFilters = this._resetAllFilters.bind(this);
        this._selectAllFilters = this._selectAllFilters.bind(this);
        this._checkAll = this._checkAll.bind(this);
        this._resetFilters = this._resetFilters.bind(this);
    }

    componentDidMount() {
        FilteringSortingStore.addListener(EventConstants.FILTERING_SORTING_CHANGE_EVENT, this._onFilteringParametersDataUpdated);
        FilteringSortingStore.addListener(EventConstants.FILTERING_SORTING_CHANGE_EVENT, this._resetFilters);
    }

    componentWillUnmount() {
        FilteringSortingStore.removeListener(EventConstants.FILTERING_SORTING_CHANGE_EVENT, this._onFilteringParametersDataUpdated);
        FilteringSortingStore.removeListener(EventConstants.FILTERING_SORTING_CHANGE_EVENT, this._resetFilters);
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
        var self = this;
        var filterCheckboxes = filterData.map(function (e, index) {
                return (
                    <FilterElement columnName={self.props.columnName}
                                   ref={self.props.columnName+index}
                                   parameterSelected={self._onFilteringParameterSelected}
                                   key={e}
                                   element={e}/>
                );
        });
        return (
            <div>
                <div className="dropdown-header">Фильтры</div>
                <div className="dropdown-option" onClick={this._selectAllFilters}>
                    <a href="#">
                        <i className="fa fa-check-square-o" aria-hidden="true">
                            <span>&nbsp;Выбрать все фильтры</span>
                        </i>
                    </a>
                </div>
                <div className="dropdown-option" onClick={this._resetAllFilters}>
                    <a href="#">
                        <i className="fa fa-square-o" aria-hidden="true">
                            <span>&nbsp;Сбросить все фильтры</span>
                        </i>
                    </a>
                </div>
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

    _resetAllFilters() {
        if (this.state.filtersChecked > 0) {
            this.setState({
                filtersChecked: 0
            });
            FilteringSortingActions.resetAllFiltersForColumn(this.props.columnName);
            this.props.enableFiltering(false);
            this._checkAll(false);
        }
    }

    _selectAllFilters() {
        if (this.state.filtersChecked !== this.state.filterData.length) {
            this.setState({
                filtersChecked: this.state.filterData.length
            });
            FilteringSortingActions.selectAllFiltersForColumn(this.props.columnName);
            this.props.enableFiltering(true);
            this._checkAll(true);
        }
    }

    _resetFilters() {
        if (this.state.filtersChecked > 0)
            if (FilteringSortingStore.getIsResetAll()) {
                this._checkAll(false);
                this.props.enableFiltering(false);
            }
    }

    _checkAll(value) {
        var filterParamCount = this.state.filterData.length;
        if (filterParamCount > 0)
            for (var i = 0; i < filterParamCount; i++) {
                this.refs[this.props.columnName + i]._setIsCheckedValue(value);
            }
    }

}

export default Filtering;