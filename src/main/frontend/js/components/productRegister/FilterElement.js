import React from 'react';
import ProductRegisterActions from '../../actions/ProductRegisterActions';
import FilteringSortingActions from '../../actions/FilteringSortingActions';

class FilterElement extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isChecked: false
        };
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
}

export default FilterElement;