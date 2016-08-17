import React from 'react';
import FilteringSortingActions from '../../actions/FilteringSortingActions';
import ProductRegisterTableActions from '../../actions/ProductRegisterTableActions';

class Sorting extends React.Component {
    constructor(props) {
        super(props);
        this.__onSortingDirectionClick = this.__onSortingDirectionClick.bind(this);
    }
    render() {
        return (
            <div>
                <div className="dropdown-header">Сортировка</div>
                <div className="sorting-option" onClick={this.__onSortingDirectionClick.bind(null, "asc")}>
                    <a href="#">
                        <i className="fa fa-sort-amount-asc" aria-hidden="true">
                            <span>&nbsp;по возрастанию</span>
                        </i>
                    </a>
                </div>
                <div className="sorting-option" onClick={this.__onSortingDirectionClick.bind(null, "desc")}>
                    <a href="#">
                        <i className="fa fa-sort-amount-desc" aria-hidden="true">
                            <span>&nbsp;по убыванию</span>
                        </i>
                    </a>
                </div>
            </div>
        );
    }

    __onSortingDirectionClick(direction) {
        FilteringSortingActions.applySorting(this.props.columnName, direction);
        ProductRegisterTableActions.loadProductsFromServer();
        this.props.enableSorting(direction);
    }
}

export default Sorting;