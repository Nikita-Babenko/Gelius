import React from 'react';
import ProductRegisterActions from '../../actions/ProductRegisterActions';
import FilteringSortingActions from '../../actions/FilteringSortingActions';
import FilteringSortingStore from '../../stores/FilteringSortingStore';
import EventConstants from '../../constants/Events';

class FilterElement extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isChecked: false
        };
        this._setIsCheckedValue = this._setIsCheckedValue.bind(this);
    }

    render() {
        return (
            <li className="checkbox">
                <label>
                    <input type="checkbox" checked={this.state.isChecked}
                           onChange={this._handleChangeSelection.bind(this)}
                           className="filter-checkbox"/>{this.props.element}
                </label>
            </li>
        );
    }

    _handleChangeSelection() {
        var newState = !this.state.isChecked;
        this.setState({isChecked: newState});
        this.props.parameterSelected(newState);
        if (newState) {
            FilteringSortingActions.addFilterParameter(this.props.columnName, this.props.element);
        } else {
            FilteringSortingActions.deleteFilterParameter(this.props.columnName, this.props.element);
        }

        ProductRegisterActions.loadProductsFromServer();
    }

    _setIsCheckedValue(value) {
        this.setState({
            isChecked: value
        })
    }
}

export default FilterElement;